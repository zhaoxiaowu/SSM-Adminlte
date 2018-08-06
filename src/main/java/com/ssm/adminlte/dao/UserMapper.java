package com.ssm.adminlte.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.adminlte.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int String(User record);

    int updateByPrimaryKey(User record);
    
    User findUserByUserCode(String usercode);
    
    List<Map<String,Object>> findObjectByPage(@Param("start")int start,
			@Param("length")int length,
			@Param("count")int count);
    
    int getRowCount();
}