package cn.senninha.web.controller;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.consts.ResConstant;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import cn.senninha.web.util.validate;
import cn.senninha.web.consts.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mysql.jdbc.StringUtils;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public Result adminCreateUser(@Valid @RequestBody UserEntity user, BindingResult bindingResult) throws BadReqeuestException{
        if(bindingResult.hasErrors()) {
            throw new BadReqeuestException(bindingResult.getFieldError().getDefaultMessage());
        }
        if(!validate.isMobile(user.getPhone())){
            throw new BadReqeuestException(ResConstant.ERR_TEL);
        }
        if(userService.selectByName(user.getUsername()) != null){
            throw new BadReqeuestException(ResConstant.ISEXIST);
        }
        user.setPassword(encrymd5.md5Password(user.getPassword()));
        return userService.insert(user);
    }
    @PutMapping("/users/{id}")
    public Result adminUpdateUser(@PathVariable("id") int id,@Valid @RequestBody UserEntity user, BindingResult bindingResult) throws Exception{
        if (userService.selectOne(id).getData() == null){
            throw new BadReqeuestException(ResConstant.NO_USER);
        }
        user.setId(id);

        if (user.getPhone() != null){
            if(!validate.isMobile(user.getPhone())){
                throw new BadReqeuestException(ResConstant.ERR_TEL);
            }
        }

        if (user.getPassword() != null){
            if(!validate.isPwd(user.getPassword())){
                throw new BadReqeuestException((ResConstant.ERR_PASSWORD_FORMAT));
            }
            user.setPassword(encrymd5.md5Password(user.getPassword()));
        }

        return userService.update(user);
    }

    @DeleteMapping("users/{id}")
    public Result adminDeleteUserById(@PathVariable("id") int id) throws Exception{
        if (userService.selectOne(id).getData()==null){
            throw new BadReqeuestException(ResConstant.NO_USER);
        }
        Result userDelete = userService.delete(id);
        return userDelete;
    }
//    //    初始化管理员
//    public UserEntity initAdmin(){
//            if(userService.isInitedAdmin(0)==null){
//                UserEntity admin = new UserEntity();
//                admin.setUsername(AdminUser.USERNAME);
//                String password = encrymd5.md5Password(AdminUser.PASSWORD);
//                admin.setPassword(password);
//                admin.setIsRoot(AdminUser.ISROOT);
//                System.out.println(admin.toString());
//                userService.initAdmin(admin);
//            }
//            return  userService.isInitedAdmin(0);
//    }

}
