package com.ssm.adminlte.service;

import java.util.List;
import java.util.Map;

import com.ssm.adminlte.entity.Permission;
import com.ssm.common.entity.Node;

public interface PermissionService {
	public int saveObject(Permission permission);
	
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count);
	
	public void deleteObject(int id);
	
	public void updateObject(Permission permission);
	
	public Permission findObjectById(int id);
	
	public int getCount();
	
	List<Node> findZTreeNodes();
}
