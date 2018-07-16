package com.jeff.yue.system.service.impl;

import com.jeff.yue.system.dao.UserDao;
import com.jeff.yue.system.domain.User;
import com.jeff.yue.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<User> findUserList(User user) {
        return userDao.findUserList(user);
    }
}
