package com.wan.dataM.core.exception;

/**
 * Created by chenran on 2017/10/18 0018.
 */
public enum BaseExceptionEnum {

    /**
     * 其他
     */
    WRITE_ERROR(500,"渲染界面错误"),

    /**
     * 文件上传
     */
    FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常");

    BaseExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    BaseExceptionEnum(int code, String message, String urlPath) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
        this.urlPath = urlPath;
    }

    private int friendlyCode;

    private String friendlyMsg;

    private String urlPath;

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
    
}
