package com.lc.admin.constant;

/**
 *
 *
 * @auth liuchong
 * @data 2019-07-03 11:42
 **/
public enum CommRespCode implements Code {
    SUCCESS(100, "OK"),
    USER_NOT_EXISTS(713, "用户不存在"),
    CALL_FAIL(820, "接口调用失败"),
    SERVER_EXCEPTION(900, "服务器异常"),
    BUSINESS_REQPARAM_EXCEPTION(901, "非法请求参数"),
    DATA_NOT_FOUND(902, "无数据记录"),
    BUSINESS_EXCEPTION(915, "业务异常"),
    JSON_PARSE_EXCEPTION(930, "json解析异常"),
    TOKEN_ABSENT_EXCEPTION(918, "token值为空或无效"),
    TOKEN_EXPIRED_EXCEPTION(919, "登录已过期"),
    /**
     * 业务处理失败
     */
    FAIL(-1, "处理失败"),

    /**
     * 业务处理失败
     */
    PROGRAM_EXCEPTION(-3, "程序异常"),

    /**
     * 业务处理失败
     */
    HTTP_EXCEPTION(-4, "http调用异常"),

    /**
     * 业务处理失败
     */
    RPC_EXCEPTION(-5, "rpc调用异常");

    private Integer code;
    private String desc;

    CommRespCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public static CommRespCode getByCode(Integer code) {
        CommRespCode s = SUCCESS;
        for(CommRespCode e : CommRespCode.values()) {
            if(e.code.equals(code)) {
                s = e;
                break;
            }
        }
        return s;
    }
}