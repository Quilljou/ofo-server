package cn.senninha.web.enums;

public enum LoginEnum {
    SUCCESS("成功",0),
    UNLOGIN("您还未登录",1),
    UNKNOW_ERROR("未知错误，请联系管理员",2),
    PASSWORD_ERROR("密码错误",3),
    NO_USER("没用这个用户",4),
    NOT_ADMIN("您不是管理员，无权访问", 5),
    NOT_OPERATOR("您不是操作员，无权访问", 6),
    NOTNULL_USERNAME("用户名不能为空",7),
    NOTNULL_PASSWORD("密码不存在",8);

    private  Integer code;
    private String msg;

    LoginEnum(String msg, Integer code ) {
        this.code = code;
        this.msg = msg;
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
