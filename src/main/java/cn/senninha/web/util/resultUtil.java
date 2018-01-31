package cn.senninha.web.util;

import cn.senninha.web.domain.Result;

public class resultUtil {
    public static final Result sessionValid() {
        Result result = fail("未登录");
        result.setLogin(false);
        return result;
    }

    public static final Result success(Object T) {
        Result result = new Result();
        result.setLogin(true);
        result.setSuccess(true);
        result.setMessage("OK");
        result.setData(T);
        return result;
    }

    public static final Result fail(String message) {
        Result result = new Result();
        result.setLogin(true);
        result.setSuccess(false);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static final Result fail(String message,int code) {
        Result result = fail(message);
        result.setCode(code);
        return result;
    }
}
