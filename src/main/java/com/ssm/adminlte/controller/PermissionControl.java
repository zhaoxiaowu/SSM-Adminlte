package com.ssm.adminlte.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.adminlte.entity.Permission;
import com.ssm.adminlte.service.PermissionService;
import com.ssm.common.entity.JsonResult;

@RequestMapping("permission/")
@Controller
public class PermissionControl {
    @Autowired
    private PermissionService permissionService;
    
	@RequestMapping("listUI")
	public String listUI(){
		return "tpl/permission_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "tpl/permission_edit";
	}
	@RequestMapping("viewUI")
	public String viewUI(){
		return "tpl/permission_detail";
	}
    @RequestMapping(value = "updateObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateObject(Permission permission) {
		JsonResult r =new JsonResult();
    	try {
    		permissionService.updateObject(permission);
    		r.setMessage("更新成功！");
    	}catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
    @RequestMapping(value = "saveObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveObject(Permission permission){ 
		JsonResult r =new JsonResult();
    	try {
        	permissionService.saveObject(permission);
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
        	Permission permission = permissionService.findObjectById(id);
        	r.setData(permission);
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
        	permissionService.deleteObject(id);
        	r.setMessage("删除成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
    	System.out.println(r.getMessage());
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
		int count = permissionService.getCount();
		Map<String, Object> map =new HashMap<>();
		map.put("draw", drawInit);// DataTable前台必须要的
		map.put("recordsTotal", permissionService.getCount());// 实际的行数，调用查询总记录数的方法
		map.put("recordsFiltered", permissionService.getCount());// 显示的行数,这个要和上面写的一样
		map.put("data", permissionService.findObjectByPage(startInit,lengthInit,count));// 把查到数据装入aaData,要以JSON格式返回
		return map;
	}
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes(){
		return new JsonResult(
		permissionService.findZTreeNodes());
	}
}