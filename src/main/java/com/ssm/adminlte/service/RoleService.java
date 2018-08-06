package com.ssm.adminlte.service;

import java.util.List;
import java.util.Map;
import com.ssm.adminlte.entity.Role;

public interface RoleService {
	public int saveObject(Role role,String permissionIds);
	
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count);
	
	public void deleteObject(Integer id);
	
	public void updateObject(Role role,String permissionIds);
	
	public Map<String,Object> findObjectById(Integer id);
	
	public int getCount();
}
