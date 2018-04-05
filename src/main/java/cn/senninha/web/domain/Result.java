package cn.senninha.web.domain;

import cn.senninha.sserver.lang.message.Message;

public class Result {
    private String message;
    private Object data;
    private int status;
    private Object pagination;

    public Result(Object data, String message, int status, Object pagination) {
        this.message = message;
        this.data = data;
        this.status = status;
        this.pagination = pagination;
    }

    public Result(Object data, String message, int status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }
}
