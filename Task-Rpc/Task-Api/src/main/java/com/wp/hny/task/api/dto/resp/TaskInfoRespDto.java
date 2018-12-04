package com.wp.hny.task.api.dto.resp;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午7:38:36
 */
public class TaskInfoRespDto implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 任务类型
	 */
	private Integer type;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 次数
	 */
	private Integer cnt;

	/**
	 * url链接
	 */
	private String url;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TaskInfoRespDto [id=" + id + ", type=" + type + ", title=" + title + ", cnt=" + cnt + ", url=" + url
				+ ", remark=" + remark + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
