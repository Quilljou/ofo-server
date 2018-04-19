package cn.senninha.web.exception;

import org.springframework.http.HttpStatus;

public class BadReqeuestException extends Exception{
    String message;
    int status;

    public BadReqeuestException(String message, int status){
        this.message = message;
        this.status = status;
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
