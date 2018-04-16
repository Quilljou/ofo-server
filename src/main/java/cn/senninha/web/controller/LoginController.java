package cn.senninha.web.controller;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.enums.LoginEnum;
import cn.senninha.web.exception.LoginException;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import cn.senninha.web.util.resultUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.StringUtils;

import java.util.Date;


@RestController
@RequestMapping(Project.API_PREFIX)
public class LoginController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login2")
//    public Result login2(@Valid @RequestBody UserEntity user, BindingResult bindingResult, HttpServletRequest request) throws Exception{
//        if(bindingResult.hasErrors()){
//            String message = bindingResult.getFieldError().getDefaultMessage();
//            throw new Exception(message);
//        }
//        UserEntity userEntity = userService.selectByName(user.getUsername());
//        //当没有查找到这个用户时，返回错误信息
//        if(userEntity==null) {
//            throw new Exception("用户名不存在");
//        }
//        String password = encrymd5.md5Password(user.getPassword());
//        System.out.println(userEntity.getPassword());
//        System.out.println(password);
//        System.out.println(userEntity.getPassword()==password);
//        if(userEntity.getPassword().equals(password)){
//            HttpSession session = request.getSession();
//            session.setMaxInactiveInterval(Project.MAXSESSIONTIME);
//            session.setAttribute("data","random");
//            String sessionId = session.getId();
//            if (session.isNew()) {
//                System.out.println("session创建成功，session的id是："+sessionId);
//            }else {
//                System.out.println("服务器已经存在该session了，session的id是："+sessionId);
//            }
//            return resultUtil.success(null);
//        }else{
//            throw new Exception("密码错误");
//        }
//
//    }

    @PostMapping("/loginform")
    public Result login1(UserEntity user,HttpServletRequest request) throws Exception{
        return login(user,request);
    }

    @PostMapping("/loginbody")
    public Result login2(@RequestBody UserEntity user,HttpServletRequest request) throws Exception{
        return login(user,request);
    }
    public Result login(UserEntity user,HttpServletRequest request){
        if(StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())){
            throw new LoginException(LoginEnum.NOTNULL_USERNAME);
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())){
            throw new LoginException(LoginEnum.NOTNULL_PASSWORD);
        }

        UserEntity userEntity = userService.selectByName(user.getUsername());
        //当没有查找到这个用户时，返回错误信息
        if(userEntity==null) {
            throw new LoginException(LoginEnum.NO_USER);
        }
        String password = encrymd5.md5Password(user.getPassword());
        // 验证密码是否正确
        if(userEntity.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(Project.MAXSESSIONTIME);
            session.setAttribute("isRoot",userEntity.getIsRoot());
            userEntity.setLastLoginTime(new Date());
            userService.updateLastLoginTime(userEntity);
            System.out.println(userEntity.getLastLoginTime());
            userEntity.setPassword("");
            return resultUtil.success(userEntity);
        }else{
            throw new LoginException(LoginEnum.PASSWORD_ERROR);
        }
    }

    @PostMapping("/loginout")
    public Result loginout(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        return resultUtil.success(null);
    }

}
