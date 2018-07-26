package com.crown.dao;

import com.crown.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User findByUserAndPass(@Param("username") String username, @Param("password")String password);
}
