package com.ssm.adminlte.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.adminlte.entity.Permission;
import com.ssm.common.entity.Node;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Map<String,Object>> findObjectByPage(@Param("start")int start,
			@Param("length")int length,
			@Param("count")int count);
    
    int getRowCount();
    
	List<Node> findZTreeNodes();
}