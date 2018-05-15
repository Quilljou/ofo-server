package cn.senninha.web.handler;

import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.exception.UnauthenticatedException;
import cn.senninha.web.exception.UnauthorizedException;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.naming.NoPermissionException;
import javax.security.auth.login.LoginException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result noHandlerFoundException(NoHandlerFoundException e) {
        return resultUtil.fail(e.getMessage(), HttpStatus.NOT_FOUND.value(), null);
    }

    @ExceptionHandler(value = BadReqeuestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result badRequest(BadReqeuestException e) {
        return resultUtil.fail(e.getMessage(), e.getStatus(), null);
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result unAuthorized(UnauthenticatedException e) {
        return resultUtil.fail(e.getMessage(), e.getStatus(), null);
    }

    // 垃圾 shiro 控制器上检查权限后抛出的异常不会自己处理？
    @ExceptionHandler({UnauthorizedException.class,org.apache.shiro.authz.UnauthorizedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Result forbidden(Exception e) {
        return resultUtil.fail("无权访问", HttpStatus.FORBIDDEN.value(), null);
    }


//    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Result defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
//        logger.error(e.getMessage());
//        return resultUtil.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
//    }

}

