package com.ssm.adminlte.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    /**
     * 判定关系表中菜单是否被角色使用
     * @param menuId
     * @return
     */
	int getPermissionCount(Integer permissionId);
	
	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("permissionIds")String[] permissionIds);
	
	List<Integer> findPermissionIdsByRoleId(
			Integer roleId);
	
	int deleteObjectByRoleId(Integer roleId);
	int deleteObjectByPermissionId(Integer permissionId);
	
	
}
