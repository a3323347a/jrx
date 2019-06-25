package com.boot.response;

/**
 *友好提示枚举
 */
public enum UnicomResponseEnums {
    /**
     * 友好错误提示枚举
     */
    SYSTEM_ERROR("-001","系统异常"),
    BAD_REQUEST("-002","错误的请求参数"),
    NOT_FOUND("-003","找不到请求路径！"),
    CONNECTION_ERROR("-004","网络连接请求失败！"),
    METHOD_NOT_ALLOWED("-005","不合法的请求方式"),
    DATABASE_ERROR("-004","数据库异常"),
    BOUND_STATEMENT_NOT_FOUNT("-006","找不到方法！"),
    NO_PERMISSION("004","非法请求！"),
    SUCCESS_OPTION("005","操作成功！");
    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;

    UnicomResponseEnums(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
