package com.ssm.adminlte.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssm.adminlte.entity.ArticleType;
import com.ssm.adminlte.service.ArticleTypeService;
import com.ssm.common.entity.JsonResult;

@RequestMapping("articleType/")
@Controller
public class ArticleTypeControl {


    @Autowired
    private ArticleTypeService articleTypeService;
    
	@RequestMapping("doLoadObjectType")
	@ResponseBody
	public JsonResult findAll(){
		List<ArticleType> articleType = articleTypeService.findAll();
		return new JsonResult(articleType);
	}
	@RequestMapping("listUI")
	public String listUI(){
		return "tpl/type_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "tpl/type_edit";
	}
    @RequestMapping(value = "updateObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateObject(ArticleType articletype) {
		JsonResult r =new JsonResult();
    	try {
    		articleTypeService.updateObject(articletype);
    		r.setMessage("更新成功！");
    	}catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
    @RequestMapping(value = "saveObject", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveObject(ArticleType articletype){ 
		JsonResult r =new JsonResult();
    	try {
        	articleTypeService.saveObject(articletype);
        	r.setMessage("保存成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
    }
    @RequestMapping(value = "findObjectById", method = RequestMethod.GET)
    @ResponseBody
	public JsonResult findObject(Long id) {
		JsonResult r =new JsonResult();
    	try {
        	ArticleType articletype = articleTypeService.findObjectById(id);
        	r.setData(articletype);
        	r.setMessage("查找成功！！");
    	}
    	catch (Exception e) {
    		r.setMessage(e.getMessage());
		}
		return r;
	}
    @RequestMapping(value = "deleteObject", method = RequestMethod.GET)
    @ResponseBody
	public JsonResult deleteObject(Long id) {
		JsonResult r =new JsonResult();
    	try {
        	articleTypeService.deleteObject(id);
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
		int startInit = 0; // 起始索0;引
		int lengthInit = 10; // 每页显示的行数
		drawInit = draw;
		lengthInit = Integer.parseInt(length);
		startInit = Integer.parseInt(start);
		int count = articleTypeService.getCount();
		Map<String, Object> map =new HashMap<>();
		map.put("draw", drawInit);// DataTable前台必须要的
		map.put("recordsTotal", articleTypeService.getCount());// 实际的行数，调用查询总记录数的方法
		map.put("recordsFiltered", articleTypeService.getCount());// 显示的行数,这个要和上面写的一样
		map.put("data", articleTypeService.findObjectByPage(startInit,lengthInit,count));// 把查到数据装入aaData,要以JSON格式返回
		return map;
	}
}