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


    @PostMapping("/login")
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
        System.out.println(user.getPassword());
        String password = encrymd5.md5Password(user.getPassword());
        // 验证密码是否正确
        if(userEntity.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(Project.MAXSESSIONTIME);
            session.setAttribute("isRoot",userEntity.getIsRoot());
            session.setAttribute("id",userEntity.getId());
            userEntity.setLastLoginTime(new Date());
            userService.updateLastLoginTime(userEntity);
            userEntity.setPassword(null);
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
