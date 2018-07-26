package com.crown.Service;

import com.crown.dao.UserDao;
import com.crown.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    public User findByUserAndPass(String username, String password) {

        return userDao.findByUserAndPass(username,password);
    }
}
