package cn.senninha.web.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends Exception{
    String message;
    int status;

    UnauthorizedException(String message, int status){
        this.message = message;
        this.status = status;
    }

    UnauthorizedException(String message){
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
