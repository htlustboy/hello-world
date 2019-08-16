package com.hello.world.orderServer.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 配置类
 * @author taohu
 *
 */
@Configuration
@Slf4j
public class OrderServerConfig {
	
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
	
	/**
	 * 创建sqlSessionFactory
	 * @return
	 */
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(environment.getProperty("mybatis.config")));
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
		try {
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));
			log.info("=============================:sqlSessionFactory创建成功");
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("=============================:sqlSessionFactory创建失败:" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * 注册自己的Servlet
	 * @return
	 */
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean(){
//		log.info("初始化Servlet-------------------------------------------------------------------------------------");
//		return new ServletRegistrationBean(new ValidServlet(), "/valid/*");
//		return null;
//	}
	
}
