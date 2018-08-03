package com.ssm.adminlte.dao;

import com.ssm.adminlte.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int String(User record);

    int updateByPrimaryKey(User record);
    
    User findUserByUserCode(String usercode);
}