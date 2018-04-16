package cn.senninha.web.handler;

import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.LoginException;
import cn.senninha.web.util.resultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        LoginException loginException = (LoginException)e;
        if(e instanceof LoginException){
            return resultUtil.fail(loginException.getMessage(),loginException.getCode());
        }
        return resultUtil.fail(e.getMessage(), 400);
    }
}
