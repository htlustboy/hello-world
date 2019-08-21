package com.hello.world.logServer.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LogServerConfig {
	
	@Resource
	private Environment environment;
	
	/**
	 * 数据库配置文件
	 * @return
	 */
	@Bean
	public DataSource getDataSource() {
		Properties properties = new Properties();
		properties.setProperty("driverClassName", environment.getProperty("spring.datasource.driver-class-name"));
		properties.setProperty("url", environment.getProperty("spring.datasource.url"));
		properties.setProperty("username", environment.getProperty("spring.datasource.username"));
		properties.setProperty("password", environment.getProperty("spring.datasource.password"));
		DataSource dataSource = null;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("=============================:数据库连接失败" + e.getMessage());
		}
		log.info("=================================:数据库连接成功！" + dataSource);
		return dataSource;
		
	}
	
//	/**
//	 * 创建sqlSessionFactory
//	 * @return
//	 */
//	@Bean
//	public MybatisSqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
//		MybatisSqlSessionFactoryBean  sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean ();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(environment.getProperty("mybatis-plus.config")));
//		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis-plus.typeAliasesPackage"));
//		//mybatis-plus拦截器生效配置
//		sqlSessionFactoryBean.setPlugins(new Interceptor[]{new OptimisticLockerInterceptor()});
//		try {
//			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis-plus.mapperLocations")));
//			log.info("=============================:sqlSessionFactory创建成功");
//			return sqlSessionFactoryBean;
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("=============================:sqlSessionFactory创建失败:" + e.getMessage());
//		}
//		return null;
//	}
}
