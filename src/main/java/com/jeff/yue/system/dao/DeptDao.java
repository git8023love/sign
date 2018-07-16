package com.jeff.yue.system.dao;

import com.jeff.yue.system.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:35:39
 */
@Mapper
public interface DeptDao {

	Dept get(Long deptId);
	
	List<Dept> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Dept dept);
	
	int update(Dept dept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);
	
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
}
