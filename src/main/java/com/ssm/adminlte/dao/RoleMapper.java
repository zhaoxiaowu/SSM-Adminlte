package com.ssm.adminlte.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.adminlte.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Map<String,Object>> findObjectByPage(@Param("start")int start,
			@Param("length")int length,
			@Param("count")int count);
    
    int getRowCount();
}