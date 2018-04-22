package cn.senninha.web.controller;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.enums.LoginEnum;
import cn.senninha.web.exception.LoginException;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import cn.senninha.web.util.validate;
import cn.senninha.web.consts.AdminUser;
import cn.senninha.web.util.resultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mysql.jdbc.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping(Project.API_PREFIX)
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public Result adminGetUsers() throws Exception {
        return userService.selectAll();
    }


    @GetMapping("/users/{id}")
    public Result adminFindUserById(@PathVariable("id") int id) throws Exception{
        return userService.selectOne(id);
    }

    @PostMapping("/users")
    public Result adminCreateUser(@RequestBody UserEntity user){
        if(user.getPassword()==null||StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())){
            throw new LoginException(LoginEnum.NOTNULL_PASSWORD);
        }

        if (user.getUsername()==null||StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())){
            throw new LoginException((LoginEnum.NOTNULL_USERNAME));
        }
        if (user.getPhone()==null||StringUtils.isEmptyOrWhitespaceOnly(user.getPhone())){
            throw new LoginException(LoginEnum.NOTNULL_PHONE);
        }
        if(!validate.isMobile(user.getPhone())){
            throw new LoginException(LoginEnum.ERR_TEL);
        }
        if(userService.selectByName(user.getUsername())!=null){
            throw new LoginException(LoginEnum.ISEXIST);
        }
        user.setPassword(encrymd5.md5Password(user.getPassword()));
        return userService.insert(user);
    }
    @PutMapping("/users/{id}")
    public Result adminUpdateUser(@PathVariable("id") int id,@RequestBody UserEntity user) throws Exception{
        if (userService.selectOne(id).getData()==null){
            throw new LoginException(LoginEnum.NO_USER);
        }
        user.setId(id);

        if (user.getPhone()!=null){
            if(!validate.isMobile(user.getPhone())){
                throw new LoginException(LoginEnum.ERR_TEL);
            }
        }

        if (user.getPassword()!=null){
            if(!validate.isPwd(user.getPassword())){
                throw new LoginException((LoginEnum.ERR_PASSWORD_FORMAT));
            }
            user.setPassword(encrymd5.md5Password(user.getPassword()));
        }


        return userService.update(user);
    }
    @PutMapping("/users/self")
    public Result allUpdateSelf(@RequestBody UserEntity user,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        user.setId((int)session.getAttribute("id"));
        if (user.getPhone()!=null){
            if(!validate.isMobile(user.getPhone())){
                throw new LoginException(LoginEnum.ERR_TEL);
            }
        }

        if (user.getPassword()!=null){
            if(!validate.isPwd(user.getPassword())){
                throw new LoginException((LoginEnum.ERR_PASSWORD_FORMAT));
            }
        }

        user.setPassword(encrymd5.md5Password(user.getPassword()));
        Result userResult =  userService.update(user);
        session.invalidate();
        return userResult;
    }

    @DeleteMapping("users/{id}")
    public Result adminDeleteUserById(@PathVariable("id") int id) throws Exception{
        if (userService.selectOne(id).getData()==null){
            throw new LoginException(LoginEnum.NO_USER);
        }
        Result userDelete = userService.delete(id);
        return userDelete;
    }
    //    初始化管理员
    public UserEntity initAdmin(){
            if(userService.isInitedAdmin(0)==null){
                UserEntity admin = new UserEntity();
                admin.setUsername(AdminUser.USERNAME);
                String password = encrymd5.md5Password(AdminUser.PASSWORD);
                admin.setPassword(password);
                admin.setIsRoot(AdminUser.ISROOT);
                System.out.println(admin.toString());
                userService.initAdmin(admin);
            }
            return  userService.isInitedAdmin(0);
    }

}
