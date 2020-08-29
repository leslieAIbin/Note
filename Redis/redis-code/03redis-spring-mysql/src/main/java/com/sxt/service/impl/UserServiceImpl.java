package com.sxt.service.impl;

import com.sxt.domain.User;
import com.sxt.mapper.UserMapper;
import com.sxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User updateByPrimaryKey(User user) {
        int index = this.userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public List<User> queryAllUser() {
        return this.userMapper.queryAllUser();
    }
}
