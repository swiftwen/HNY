package com.wp.hny.task.api.dto.req;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author swiftwen
 * @date 2018年12月4日 下午3:46:33
 */
public class AddWxTaskReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message="title格式错误")
	private String title;

	@Range(min = 1,max = 10000, message="数量: 必须大于0,小于10000")
	@NotNull(message="数量不能为空")
	private Integer cnt;
	
	@NotBlank(message="url格式错误")
	private String url;

	private String remark;
	
	@JSONField(serialize=false)
	private Integer type;
	
	public Integer getType() {
		return type;
	}

	
	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AddWxPraseTaskReqDto [title=" + title + ", cnt=" + cnt + ", url=" + url + ", remark=" + remark + "]";
	}
}
