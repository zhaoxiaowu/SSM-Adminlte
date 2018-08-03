package com.ssm.adminlte.entity;

import java.io.Serializable;
import java.util.List;


public class ActiveUser implements Serializable{
	private String userid;//用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称

	private List<Permission> menus;// 菜单
	private List<Permission> permissions;// 权限

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<Permission> getMenus() {
		return menus;
	}

	public void setMenus(List<Permission> menus) {
		this.menus = menus;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	
	
}
