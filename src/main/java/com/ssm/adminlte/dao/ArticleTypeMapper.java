package com.ssm.adminlte.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.adminlte.entity.ArticleType;
import com.ssm.adminlte.entity.Page;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
    
    List<ArticleType> findAll();
    
    List<Map<String,Object>> findObjectByPage(@Param("start")int start,
    		@Param("length")int length,
    		@Param("count")int count);
    
    int getRowCount();
}