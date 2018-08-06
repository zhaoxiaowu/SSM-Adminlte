package com.ssm.adminlte.service.impl;



import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.adminlte.dao.PermissionMapper;
import com.ssm.adminlte.entity.Permission;
import com.ssm.adminlte.service.PermissionService;
import com.ssm.common.entity.Node;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	@Override
	public List<Node> findZTreeNodes() {
		return permissionMapper.findZTreeNodes();
	}
	@Override
	public int saveObject(Permission Permission) {
		return permissionMapper.insert(Permission);
	}
	@Override
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count){
		return permissionMapper.findObjectByPage(start,length,count);
	}
	@Override
	public void deleteObject(int id) {
		permissionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void updateObject(Permission Permission) {
		permissionMapper.updateByPrimaryKeySelective(Permission);
	}
	@Override
	public Permission findObjectById(int id) {
		return permissionMapper.selectByPrimaryKey(id);
	}
	@Override
	public int getCount() {
		return permissionMapper.getRowCount();
	}

}
