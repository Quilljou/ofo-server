package cn.senninha.web.handler;

import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.exception.LoginException;
import cn.senninha.web.exception.UnauthorizedException;
import cn.senninha.web.util.resultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler{

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

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result unAuthorized(UnauthorizedException e) {
        return resultUtil.fail(e.getMessage(), e.getStatus(), null);
    }

    @ExceptionHandler(value = LoginException.class)
    //@ResponseStatus(HttpStatus.)
    @ResponseBody
    public Result login(LoginException e) {
        return resultUtil.fail(e.getMessage(), e.getCode(), null);
    }

    @ExceptionHandler(value = NoPermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Result forbidden(Exception e) {
        return resultUtil.fail(e.getMessage(), HttpStatus.FORBIDDEN.value(), null);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        return resultUtil.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

}

