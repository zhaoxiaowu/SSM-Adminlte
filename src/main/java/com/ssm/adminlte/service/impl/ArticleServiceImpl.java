package com.ssm.adminlte.service.impl;



import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.adminlte.dao.ArticleMapper;
import com.ssm.adminlte.entity.Article;
import com.ssm.adminlte.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public int saveObject(Article article) {
		return articleMapper.insert(article);
	}
	@Override
	public List<Map<String,Object>> findObjectByPage(int start,int length,int count){
		return articleMapper.findObjectByPage(start,length,count);
	}
	@Override
	public void deleteObject(Long id) {
		articleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void updateObject(Article article) {
		articleMapper.updateByPrimaryKeySelective(article);
	}
	@Override
	public Article findObjectById(long id) {
		return articleMapper.selectByPrimaryKey(id);
	}
	@Override
	public int getCount() {
		return articleMapper.getRowCount();
	}

}
