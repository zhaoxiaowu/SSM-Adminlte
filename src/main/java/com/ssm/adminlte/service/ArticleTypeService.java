package com.ssm.adminlte.service;

import java.util.List;
import java.util.Map;
import com.ssm.adminlte.entity.ArticleType;

public interface ArticleTypeService {
	
	public List<ArticleType> findAll();
	
	public int saveObject(ArticleType articletype);
	
	public void deleteObject(Long id);
	
	public void updateObject(ArticleType articletype);
	
	public ArticleType findObjectById(long id);
	
	public int getCount();
	
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count);
}
