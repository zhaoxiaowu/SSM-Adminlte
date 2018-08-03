package com.ssm.adminlte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.adminlte.dao.UserMapper;
import com.ssm.adminlte.entity.User;
import com.ssm.adminlte.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int saveUser(User User) {
		return userMapper.insert(User);
	}
	@Override
	public void deleteUser(String id) {
		userMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void modifyUser(User User) {
		userMapper.updateByPrimaryKey(User);
	}
	@Override
	public User findUser(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public User findUserByUserCode(String usercode) {
		return userMapper.findUserByUserCode(usercode);
	};


}
