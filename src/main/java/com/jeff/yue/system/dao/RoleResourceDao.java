package com.jeff.yue.system.dao;

import com.jeff.yue.system.domain.RoleResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleResourceDao {

	RoleResource get(Long id);
	
	List<RoleResource> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleResource roleMenu);
	
	int update(RoleResource roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<Long> listMenuIdByRoleId(Long roleId);
	
	int removeByRoleId(Long roleId);
	
	int batchSave(List<RoleResource> list);
}
