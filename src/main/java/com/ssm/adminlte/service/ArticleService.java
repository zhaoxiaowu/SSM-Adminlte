package com.ssm.adminlte.service;

import java.util.List;
import java.util.Map;
import com.ssm.adminlte.entity.Article;

public interface ArticleService {
	public int saveObject(Article article);
	
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count);
	
	public void deleteObject(Long id);
	
	public void updateObject(Article article);
	
	public Article findObjectById(long id);
	
	public int getCount();
}
