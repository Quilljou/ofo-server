package cn.senninha.web.exception;

import cn.senninha.web.enums.LoginEnum;

public class LoginException extends RuntimeException{
    private Integer code;
    private String msg;

    public LoginException(LoginEnum resultEnum) {
        super(resultEnum.getMsg());
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
