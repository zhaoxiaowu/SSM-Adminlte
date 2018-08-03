package com.ssm.adminlte.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.ssm.adminlte.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Map<String,Object>> findObjectByPage(@Param("start")int start,
    			@Param("length")int length,
    			@Param("count")int count);
    int getRowCount();
}