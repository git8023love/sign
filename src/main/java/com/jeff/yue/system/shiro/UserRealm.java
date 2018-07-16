package com.jeff.yue.system.shiro;

import com.jeff.yue.common.utils.ShiroUtils;
import com.jeff.yue.system.domain.User;
import com.jeff.yue.system.service.ResourceService;
import com.jeff.yue.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeff.yue.system.domain.Resource;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    ResourceService resourceService;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = ShiroUtils.getUserId();
        //获取用户资源
        List<Resource> resourcesList = resourceService.findUserResourceByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Resource resource: resourcesList){
            info.addStringPermission(resource.getUrl());
        }
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String userName = (String)token.getPrincipal();
        String passWord = new String((char[]) token.getCredentials());
        User user = new User();
        user.setUsername(userName);
        user = userService.findUserList(user).get(0);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        // 密码错误
        if (!passWord.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, passWord, getName());
        return info;
    }
}
