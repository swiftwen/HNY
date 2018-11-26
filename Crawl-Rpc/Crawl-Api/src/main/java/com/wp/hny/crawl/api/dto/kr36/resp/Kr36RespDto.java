package com.wp.hny.crawl.api.dto.kr36.resp;

import java.io.Serializable;

/**
 * 
 * @author swiftwen
 * @date 2018年10月23日 上午9:55:39
 */
public class Kr36RespDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private Long timestamp;
	
    private Kr36DataDto data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Kr36DataDto getData() {
		return data;
	}

	public void setData(Kr36DataDto data) {
		this.data = data;
	}
    
    
}
