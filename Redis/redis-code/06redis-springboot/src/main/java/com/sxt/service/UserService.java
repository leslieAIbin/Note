package com.sxt.service;

import com.sxt.domain.User;

import java.util.List;

public interface UserService{


    int deleteByPrimaryKey(Integer id);

    User insert(User user);


    User selectByPrimaryKey(Integer id);


    User updateByPrimaryKey(User user);

    List<User> queryAllUser();

}
