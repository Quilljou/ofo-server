package cn.senninha.web.handler;

import cn.senninha.web.domain.Result;
import cn.senninha.web.util.resultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        return resultUtil.fail(e.getMessage(), 400);
    }
}
