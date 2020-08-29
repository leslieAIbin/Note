package com.sxt.service.impl;

import com.sxt.domain.User;
import com.sxt.mapper.UserMapper;
import com.sxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @CacheEvict(cacheNames = "user",key = "#id")
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }


//    @CachePut(cacheNames = "user",key = "#user.id")
    @CachePut(cacheNames = "user",key = "#result.id+'-'+#result.flag")
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    @Cacheable(cacheNames = "user",key = "#id")
    @Override
    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    @CachePut(cacheNames = "user",key = "#user.id")
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
