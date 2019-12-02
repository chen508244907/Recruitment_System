package com.test.recruit.config;


import com.test.recruit.vo.MyShiroRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityMapper") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean ();
        /*配置安全管理器*/
        factoryBean.setSecurityManager (securityManager);
        /*设置shiro鉴权的过滤链*/
        Map<String, String> map = new HashMap<> ();
        map.put ( "index","authc" );/*必须登录后，方可访问*/
        factoryBean.setFilterChainDefinitionMap (map);
        factoryBean.setLoginUrl ("/login");/*设置登录页*/
        return factoryBean;
    }

    /*创建shiro的安全管理器*/
    @Bean("securityMapper")
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") AuthorizingRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager ();
        manager.setRealm (myRealm);
        return manager;
    }

    /*自定义认证授权的安全策略*/
    @Bean("myRealm")
    public MyShiroRealm getMyShiorRealm(){
        return new MyShiroRealm();
    }
}
