package com.crown.Service;

import com.crown.entity.User;

public interface IUserService {

    User findByUserAndPass(String username, int password);
}
