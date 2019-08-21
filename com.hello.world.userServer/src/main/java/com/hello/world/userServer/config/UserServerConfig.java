package com.hello.world.userServer.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

import lombok.extern.slf4j.Slf4j;

/**
 * 配置类
 * @author taohu
 *
 */
@EnableTransactionManagement
@Configuration
@Slf4j
public class UserServerConfig {
	
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
	public MybatisSqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
		MybatisSqlSessionFactoryBean  sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean ();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(environment.getProperty("mybatis-plus.config")));
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis-plus.typeAliasesPackage"));
		//mybatis-plus拦截器生效配置
		sqlSessionFactoryBean.setPlugins(new Interceptor[]{new OptimisticLockerInterceptor()});
		try {
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis-plus.mapperLocations")));
			log.info("=============================:sqlSessionFactory创建成功");
			return sqlSessionFactoryBean;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("=============================:sqlSessionFactory创建失败:" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * mybatis乐观锁插件
	 * @return
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}
	
	@Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
	
	/**
	 * 配置redis缓存,获取缓存池
	 * @return
	 */
//	@Bean(name="jedisPool")
//	public JedisPool getJedisPool(){
//		JedisPoolConfig config = new JedisPoolConfig();
//		config.setMaxTotal(Integer.parseInt(environment.getProperty("redis.maxtotal")));
//		config.setMaxIdle(Integer.parseInt(environment.getProperty("redis.maxidle")));
//		config.setMaxWaitMillis(Long.parseLong(environment.getProperty("redis.maxwaitmillis")));
//		String host = environment.getProperty("redis.address");
//		int port = Integer.parseInt(environment.getProperty("redis.port"));
//		log.info("获取redis缓存池-----------------------------------------------------------------------------------");
//		return new JedisPool(config, host, port,3000);
//	}
	
	/**
	 * 初始化redis
	 * @param jedisPool
	 * @return
	 */
//	@Bean
//	@ConditionalOnMissingBean(RedisClient.class)
//	public RedisClient getRedisUtil(JedisPool jedisPool){
//		RedisClient redClient = new RedisClient();
//		redClient.setJedisPool(jedisPool);
//		logger.info("初始化redis--------------------------------------------------------------------------------------");
//		return redClient;
//	}
	
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
