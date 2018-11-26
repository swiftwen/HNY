package com.wp.hny.crawl.api.dto.kr36.resp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @desc 
 * @author swiftwen
 * @date 2018年10月23日 上午9:59:09
 */
public class Kr36Dto {

	private Long id;
	@JSONField(name="column_id")
	private Integer columnId;
	private String title;
	
	private String description;
	
	@JSONField(name="created_at")
	private String createTime;
	
	@JSONField(name="published_at")
	private String publishedTime;
	
	@JSONField(name="news_url")
	private String newsUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	
}
