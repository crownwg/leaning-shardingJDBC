package com.crown.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

public class MemberSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

    /**
     * sql between 规则
     */
    public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            Long modValue = i % 100;
            String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
            for (String each : tableNames) {
                if (each.endsWith(modStr)) {
                    result.add(each);
                }
            }
        }
        return result;
    }

    /**
     * sql == 规则
     */
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
        Long modValue = shardingValue.getValue() % 100;
        String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
        for (String each : tableNames) {
            if (each.endsWith(modStr)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * sql in 规则
     */
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {

        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
        for (long value : shardingValue.getValues()) {
            Long modValue = value % 100;
            String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
            for (String tableName : tableNames) {
                if (tableName.endsWith(modStr)) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}
