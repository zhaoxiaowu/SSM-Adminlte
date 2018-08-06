package com.ssm.adminlte.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.adminlte.dao.RoleMapper;
import com.ssm.adminlte.dao.RolePermissionMapper;
import com.ssm.adminlte.entity.Role;
import com.ssm.adminlte.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Override
	public int saveObject(Role role,String permissionIds) {
		int row = roleMapper.insert(role);
		rolePermissionMapper.insertObject(role.getId(), permissionIds.split(","));
		return row;
	}
	@Override
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count){
		return roleMapper.findObjectByPage(start,length,count);
	}
	@Override
	public void deleteObject(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		rolePermissionMapper.deleteObjectByRoleId(id);
	}
	@Override
	public void updateObject(Role role,String permissionIds) {
		roleMapper.updateByPrimaryKeySelective(role);
		rolePermissionMapper.deleteObjectByRoleId(role.getId());
		rolePermissionMapper.insertObject(role.getId(), permissionIds.split(","));
	}
	@Override
	public Map<String,Object> findObjectById(Integer id) {
		Role role = roleMapper.selectByPrimaryKey(id);
    	List<Integer> permissionIds=rolePermissionMapper.findPermissionIdsByRoleId(id);
    	Map<String,Object> map=new HashMap<String, Object>();
    	map.put("role", role);
    	map.put("menuIds", permissionIds);
    	return map;
	}
	@Override
	public int getCount() {
		return roleMapper.getRowCount();
	}

}
