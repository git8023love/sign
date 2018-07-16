package com.jeff.yue.system.service;

import com.jeff.yue.system.domain.User;

import java.util.List;

public interface UserService {

	List<User> findUserList(User user);
}
