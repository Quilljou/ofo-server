package cn.senninha.web.exception;

import cn.senninha.web.consts.ResConstant;
import org.springframework.http.HttpStatus;

public class UnauthenticatedException extends Exception{
    String message;
    int status;

    public UnauthenticatedException(ResConstant resConstant){
        this.message = resConstant.getMsg();
        this.status = resConstant.getCode();
    }

    public UnauthenticatedException(String message){
        this.message = message;
        this.status = HttpStatus.UNAUTHORIZED.value();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
