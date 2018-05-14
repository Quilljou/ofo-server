package cn.senninha.web.controller;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.consts.ResConstant;
import cn.senninha.web.domain.RequestLoginBean;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.exception.UnauthorizedException;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import cn.senninha.web.util.resultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;



@RestController
@RequestMapping(Project.API_PREFIX)
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(
            @RequestBody RequestLoginBean requestLoginBean
    ) throws BadReqeuestException {
        String username = requestLoginBean.getUsername();
        String password = requestLoginBean.getPassword();
        if(StringUtils.isEmpty(username)){
            throw new BadReqeuestException(ResConstant.NOTNULL_USERNAME);
        }
        if (StringUtils.isEmpty(password)){
            throw new BadReqeuestException(ResConstant.NOTNULL_PASSWORD);
        }

        UserEntity userEntity = userService.selectByName(username);
        //当没有查找到这个用户时，返回错误信息
        if(userEntity == null) {
            throw new BadReqeuestException(ResConstant.NO_USER);
        }
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login( new UsernamePasswordToken(username, encrymd5.md5Password(password)) );
            //从session取出用户信息
            String user = (String) currentUser.getPrincipal();
            if (user == null) throw new AuthenticationException();
            //返回登录用户的信息给前台，含用户的所有角色和权限
            userEntity.setPassword(null);
            return resultUtil.success(userEntity);
        } catch ( UnknownAccountException uae ) {
            throw new BadReqeuestException(ResConstant.PASSWORD_ERROR);
        } catch ( IncorrectCredentialsException ice ) {
            throw new BadReqeuestException("用户帐号或密码不正确");
        } catch ( AuthenticationException ae ) {
            throw new BadReqeuestException("登录出错");
        }

    }

    @PostMapping("/logout")
    public Result logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return resultUtil.success(null);
    }

    @GetMapping("/self")
    public Result allUpdateSelf() throws Exception{
        Subject currentUser = SecurityUtils.getSubject();
        String username = (String) currentUser.getPrincipal();
        UserEntity userEntity = userService.selectByName(username);
        userEntity.setPassword(null);
        return resultUtil.success(userEntity);
    }

    @GetMapping("/401")
    public Result unauthenticed() throws UnauthorizedException{
        throw new UnauthorizedException(ResConstant.UNLOGIN);
    }

}
