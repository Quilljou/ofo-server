package cn.senninha.web.shiro;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.service.UserService;
import cn.senninha.web.util.encrymd5;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserEntity userEntity = userService.selectByName(username);
        System.out.println(userEntity.toString());
        if(userEntity.getIsRoot() == true) {
            Set<String> role = new HashSet<>();
            role.add("root");
            authorizationInfo.setRoles(role);
        }
        return authorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = userService.selectByName(username).getPassword();
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
