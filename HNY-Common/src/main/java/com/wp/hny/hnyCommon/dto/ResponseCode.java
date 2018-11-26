package com.wp.hny.hnyCommon.dto;

/**
 * 响应错误码
 * @author swiftwen
 * @date 2018年11月26日 上午11:57:57
 */
public enum ResponseCode {

    SUCCESS_DEFAULT(0),
    SUCCESS(0,""),
    FAIL(-1,"操作失败"),
    PAGE_QUERY_INVALID(-2,"分页参数为空或数据格式不正确"),
	SERVER_ERROR(500, "系统繁忙，请稍后再试!"),

    PARAM_INVALID(2,"参数错误"),
    ILLEGAL_REQUEST(3,"异常请求"),
    OPERATION_FORBIDDEN(4,"统繁忙，请稍后重试"),
    SESSION_KEY_EXPIRE(5,"会话已过期，请重新登陆"),
    INTERNAL_SERVER_ERROR(500,"系统繁忙，请稍后重试"),
    ILLEGAL_JSON_ERROR(400,"非法JSON数据格式"),
    ILLEGAL_JSON_FORMAT_ERROR(401,"数据类型格式不正确"),
    ILLEGAL_REQUEST_BODY_ERROR(402,"请求数据为空或数据格式不正确"),
    IDEMPOTENT_ERROR(10,"请误重复操作"),

    /**
     * account 100001开始
     */
    ACCOUNT_EXIST(100001,"账号已存在"),
    ACCOUNT_NOT_EXIST(100002,"账号不存在"),
    SESSION_INVALID(100003,"会话失效，请重新登录"),
    SMS_CODE_ERROR(100004,"短信验证码错误"),
	SMS_FREQUENT(100005, "操作过于频繁，请稍后再试!"),
    ADMIN_NOT_EXIST(100006,"管理员不存在"),
    CHECK_ADMIN_FAIL(100007,"管理员校验失败"),
    RESEND_LOGIN_SMS_KEY_INVALID(100008,"重发短信令牌无效"),
    RESEND_LOGIN_SMS_KEY_ERROR(100009,"重发短信令牌不匹配"),
    ACCOUNT_ALREADY_FROZEN(100010,"账号已冻结"),
    SMS_FREQUENT_ONE_DAY(100011,"当天下发短信达到最大值"),
    SMS_CODE_OVERDUE(100012,"短信验证码过期"),
    PWD_ERROR(100013,"密码错误"),
    MOBILE_ALREADY_REGISTER(100014,"手机号已注册"),
    IDCARD_ALREADY_REGISTER(100015,"身份证已注册"),
    ROLE_EXIST(100016,"角色已存在"),
    RESOURCE_NOT_NULL(100017,"权限配置不能为空");


    final private int code;
    final private String msg;

    ResponseCode(int code){
        this.code = code;
        this.msg="";
    }

    ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

