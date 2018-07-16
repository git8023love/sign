package com.jeff.yue.system.dao;

import com.jeff.yue.system.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-02 20:24:47
 */
@Mapper
public interface RoleDao {

	Role get(Long roleId);
	
	List<Role> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Role role);
	
	int update(Role role);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
