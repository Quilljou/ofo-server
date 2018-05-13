package cn.senninha.web.consts;

public enum ResConstant {
    UNLOGIN("您还未登录",401),
    UNKNOW_ERROR("未知错误，请联系管理员",500),
    PASSWORD_ERROR("密码错误",400),
    NO_USER("没有这个用户",400),
    NOT_ADMIN("您不是管理员，无权访问", 401),
    NOT_OPERATOR("您不是操作员，无权访问", 401),
    NOTNULL_USERNAME("用户名不能为空",400),
    NOTNULL_PASSWORD("密码不能为空",400),
    NOTNULL_PHONE("电话号码不能为空",400),
    ISEXIST("该用户名已经存在",400),
    ERR_TEL("手机号码格式错误",400),
    ERR_PASSWORD_FORMAT("密码格式错误",400);

    private  Integer code;
    private String msg;

    ResConstant(String msg, Integer code ) {
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
