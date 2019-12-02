package com.test.recruit.vo;

import com.test.recruit.bean.Permission;
import com.test.recruit.bean.Register;
import com.test.recruit.service.PermissionService;
import com.test.recruit.service.RegisterService;
import com.test.recruit.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    public static final Logger logger= LogManager.getLogger(MyShiroRealm.class);

    /*注入业务对象*/
    @Autowired
    private RegisterService registerService;
    @Autowired
    private PermissionService permissionService;

    /*授权:查询该对象所拥有的权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal =(String) principalCollection.getPrimaryPrincipal ();
        logger.info (primaryPrincipal+"====================================================");
        List<Permission> perm = permissionService.findPermByLoginName ( primaryPrincipal );
        if(perm!=null){/*权限去重*/
            Set<String> perms=new HashSet<> () ;
            for(Permission permission:perm){
                perms.add (permission.getPer_name ());
                logger.info (perm);
            }
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo ();
            authorizationInfo.setStringPermissions (perms);
            return authorizationInfo;
        }
        return null;
    }

    @Override/*令牌：根据用户信息给予登录令牌*/
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*获取用户信息*/
        String principal =(String) token.getPrincipal ();
        Register register = registerService.findByName ( principal );
        if(register!=null){
            String password=register.getPassword ();
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (principal,password,this.getName ());
            return authenticationInfo;
        }
        return null;
    }
}
