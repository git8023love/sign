package com.jeff.yue.system.service;

import com.jeff.yue.system.domain.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> findUserResourceByUserId(Long userId);
}
