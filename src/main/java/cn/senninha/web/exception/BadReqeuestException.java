package cn.senninha.web.exception;

import cn.senninha.web.consts.ResConstant;
import org.springframework.http.HttpStatus;

public class BadReqeuestException extends Exception{
    String message;
    int status;

    public BadReqeuestException(ResConstant resConstant){
        this.message = resConstant.getMsg();
        this.status = resConstant.getCode();
    }

    public BadReqeuestException(String message){
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST.value();
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
