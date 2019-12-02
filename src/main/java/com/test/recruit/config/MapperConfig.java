package com.test.recruit.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class MapperConfig {

    @Bean
    public MapperScannerConfigurer scannerConfigurer(){
        MapperScannerConfigurer configurer=new MapperScannerConfigurer ();
        configurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");//设置sql会话工厂
        configurer.setBasePackage ("com.test.recruit.mapper"); //设置扫描的mapper接口
        Properties properties=new Properties () ;
        properties.setProperty ("notEmpty","false");//默认时，是否为空
        properties.setProperty ("IDENTITY","MYSQL");//主键策略遵循的数据库标准
        properties.setProperty ("mappers","com.test.recruit.config.BaseMapper");//设置通用父mapper
        configurer.setProperties (properties);
        return configurer;
    }
}
