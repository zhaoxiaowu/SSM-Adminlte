package com.ssm.adminlte.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.adminlte.entity.Role;
import com.ssm.adminlte.service.RoleService;
import com.ssm.common.entity.JsonResult;

@RequestMapping("role/")
@Controller
public class RoleControl {
    @Autowired
    private RoleService roleService;
    
	@RequestMapping("listUI")
	public String listUI(){
		return "tpl/role_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "tpl/role_edit";
	}
	@RequestMapping("viewUI")
	public String viewUI(){
		return "tpl/role_detail";
	}
    @RequestMapping(value = "updateObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateObject(Role role,String permissionIds) {
		JsonResult r =new JsonResult();
    	try {
    		roleService.updateObject(role,permissionIds);
    		r.setMessage("更新成功！");
    	}catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
    @RequestMapping(value = "saveObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveObject(Role role,String permissionIds){ 
		JsonResult r =new JsonResult();
    	try {
        	roleService.saveObject(role,permissionIds);
        	r.setMessage("保存成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
    }
    @RequestMapping(value = "findObjectById", method = RequestMethod.GET)
    @ResponseBody
	public JsonResult findObject(int id) {
		JsonResult r =new JsonResult();
    	try {
    		Map<String,Object> map  = roleService.findObjectById(id);
        	r.setData(map);
        	r.setMessage("查找成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
    @RequestMapping(value = "deleteObject", method = RequestMethod.GET)
    @ResponseBody
	public JsonResult deleteObject(int id) {
		JsonResult r =new JsonResult();
    	try {
        	roleService.deleteObject(id);
        	r.setMessage("删除成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
	@RequestMapping(value = "getList")
	@ResponseBody
	public Map<String, Object> getListByPage(@RequestParam String start,@RequestParam String length,@RequestParam String draw) {
		String drawInit = null;
		int startInit = 0; // 起始索引
		int lengthInit = 10; // 每页显示的行数
		drawInit = draw;
		lengthInit = Integer.parseInt(length);
		startInit = Integer.parseInt(start);
		int count = roleService.getCount();
		Map<String, Object> map =new HashMap<>();
		map.put("draw", drawInit);// DataTable前台必须要的
		map.put("recordsTotal", roleService.getCount());// 实际的行数，调用查询总记录数的方法
		map.put("recordsFiltered", roleService.getCount());// 显示的行数,这个要和上面写的一样
		map.put("data", roleService.findObjectByPage(startInit,lengthInit,count));// 把查到数据装入aaData,要以JSON格式返回
		return map;
	}
}