package com.wp.hny.hnyCommon.dto;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 响应报文格式
 * @author swiftwen
 * @date 2018年11月26日 上午11:54:46
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -5555873589143384502L;

    private String            msg;
    private int               code;
    private int               subCode;
    private T                 data;

    public static class Empty {
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(int code, int subCode, String msg, T data) {
        this.code = code;
        this.subCode = subCode;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSubCode() {
        return subCode;
    }

    public void setSubCode(int subCode) {
        this.subCode = subCode;
    }

    public T getData() {
        return data;

    }

    public void setData(T data) {
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getMsg();
        this.data = data;
    }

    @JSONField(serialize = false)
    public boolean isSuccess() {
        return code == 0;
    }

    @JSONField(serialize = false)
    public boolean isNotNullOrEmpty() {
        return code == 0&&data!=null;
    }

    @JSONField(serialize = false)
    public boolean dataIsNull() {
        return data==null;
    }

    public static class EmptyData {

    }

    @Override
    public String toString() {
        return "BaseResponse{" + "msg='" + msg + '\'' + ", code=" + code + ", subCode=" + subCode
                + ", data=" + data + '}';
    }

    public BaseResponse() {
    }

    public BaseResponse(String msg) {
        this.msg=msg;
    }

    public BaseResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public BaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public BaseResponse(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        this.setData(data);
    }
}
