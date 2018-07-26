package com.crown.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwentao on 2017/4/12.
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String helloWord(){
        System.out.print("访问index后台。。。");
        return "index";
    }
}
