package cn.senninha.web.controller;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.LoginException;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import cn.senninha.web.consts.AdminUser;
import cn.senninha.web.util.resultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mysql.jdbc.StringUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(Project.API_PREFIX)
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public Result adminGetUsers() throws Exception {
        return userService.selectAll();
    }

//    @ExceptionHandler({LoginException.class})
//    public Result handle(Exception e) throws RuntimeException{
//        System.out.println("kk");
//        LoginException loginException = (LoginException)e;
//        if(e instanceof LoginException){
//            return resultUtil.fail(loginException.getMessage(),loginException.getCode());
//        }
//        throw  new RuntimeException(loginException.getMessage());
//    }

//    public UserEntity isInitedAdmin(){
//        try{
//            return  userService.isInitedAdmin();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return new UserEntity();
//    }

    @PostMapping("/findUserByWho")
    public Result adminFindUserByWho(@RequestBody UserEntity user, HttpServletRequest request) throws Exception{
        System.out.println(user.getUsername() + "\t"+ user.getPhone() + "\t"+ user.getId());
        return userService.selectByWho(user);
    }

    //    初始化管理员
    public UserEntity initAdmin(){
            if(userService.isInitedAdmin(0)==null){
                UserEntity admin = new UserEntity();
                admin.setUsername(AdminUser.USERNAME);
                String password = encrymd5.md5Password(AdminUser.PASSWORD);
                admin.setPassword(password);
                admin.setIsRoot(AdminUser.ISROOT);
                userService.initAdmin(admin);
            }
            return  userService.isInitedAdmin(0);
    }

}
