package com.ssm.adminlte.entity;


import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ssm.adminlte.util.DateFormatConverter;

public class Article {
    private Long id;

    private Long articletypeId;

    private String author;
    
    private Date createtime;

    private String title;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticletypeId() {
        return articletypeId;
    }

    public void setArticletypeId(Long articletypeId) {
        this.articletypeId = articletypeId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }


    public String getTitle() {
        return title;
    }

	public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

	@JsonSerialize(using = DateFormatConverter.class)
    public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}