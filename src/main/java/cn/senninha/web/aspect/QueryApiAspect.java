package cn.senninha.web.aspect;

import cn.senninha.web.exception.LoginException;
import cn.senninha.web.util.operateCookie;
import cn.senninha.web.enums.LoginEnum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class QueryApiAspect {
    private final static Logger logger = LoggerFactory.getLogger(QueryApiAspect.class);

    // 有管理员权限能访问的控制器方法
    @Pointcut("execution(public * cn.senninha.web.controller..admin*(..))")
    public void admins(){
    }
    // 有操作员能访问的控制器方法
    @Pointcut("execution(public * cn.senninha.web.controller..operator*(..))")
    public void operators(){

    }
    //操作员和管理员都能访问的控制器
    @Pointcut("execution(public * cn.senninha.web.controller..all*(..))")
    public void all(){

    }

    @Before("admins()")
    public void isAdmin() throws RuntimeException{
        int isroot = checkLogin();
        if(isroot!=0) {
            throw new LoginException(LoginEnum.NOT_ADMIN);
        }
    }
    @Before("operators()")
    public void isOperator() throws RuntimeException{
        int isroot = checkLogin();
        if(isroot!=1) {
            throw new LoginException(LoginEnum.NOT_OPERATOR);
        }
    }

    @Before("all()")
    public void isAll() throws RuntimeException{
        int isroot = checkLogin();
    }



    public static int checkLogin() throws RuntimeException{
        ServletRequestAttributes resquestAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = resquestAttr.getRequest();
        Cookie cookieSession = operateCookie.getCookieByName(request,"JSESSIONID");
        HttpSession session = request.getSession();
        if (!session.isNew() && cookieSession.getValue().equals(session.getId())){
            int isroot = (int)session.getAttribute("isRoot");
            return isroot;

        }else{
            session.invalidate();
            throw new LoginException(LoginEnum.UNLOGIN);
        }
    }
}

