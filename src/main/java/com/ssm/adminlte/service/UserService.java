package com.ssm.adminlte.service;

import com.ssm.adminlte.entity.User;

public interface UserService {
	
	public int saveUser(User User);
	
	public void deleteUser(Integer id);
	
	public void modifyUser(User User);
	
	public User findUser(Integer id);
	
	public User findUserByUserCode(String usercode);

}
