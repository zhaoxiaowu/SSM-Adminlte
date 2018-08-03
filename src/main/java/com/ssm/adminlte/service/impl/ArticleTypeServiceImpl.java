package com.ssm.adminlte.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.adminlte.dao.ArticleTypeMapper;
import com.ssm.adminlte.entity.ArticleType;
import com.ssm.adminlte.service.ArticleTypeService;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService{
	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	@Override
	public List<ArticleType> findAll() {
		return articleTypeMapper.findAll();
	}
	@Override
	public int saveObject(ArticleType articletype) {
		return articleTypeMapper.insert(articletype);
	}
	@Override
	public void deleteObject(Long id) {
		articleTypeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void updateObject(ArticleType articletype) {
		articleTypeMapper.updateByPrimaryKeySelective(articletype);
	}
	@Override
	public ArticleType findObjectById(long id) {
		return articleTypeMapper.selectByPrimaryKey(id);
	}
	@Override
	public int getCount() {
		return articleTypeMapper.getRowCount();
	}
	@Override
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count){
		return articleTypeMapper.findObjectByPage(start,length,count);
	}
}
