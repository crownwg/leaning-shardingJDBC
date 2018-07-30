package com.crown.Controller;

import com.crown.Service.IUserService;
import com.crown.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String userName=request.getParameter("username");
        String  password=request.getParameter("password");
        User user= userService.findByUserAndPass(userName,Integer.valueOf(password));
        System.out.print(user!=null?"用户id:"+user.getId():"用户不存在");
        return user!=null?"hello":"error";
    }
}
