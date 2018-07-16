package com.jeff.yue.system.dao;

import com.jeff.yue.system.domain.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ResourceDao {

	List<Resource> findUserResourceByUserId(Long userId);
}
