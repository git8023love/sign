package com.jeff.yue.system.service.impl;

import com.jeff.yue.system.dao.ResourceDao;
import com.jeff.yue.system.domain.Resource;
import com.jeff.yue.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;
    @Override
    public List<Resource> findUserResourceByUserId(Long userId) {
        return resourceDao.findUserResourceByUserId(userId);
    }
}
