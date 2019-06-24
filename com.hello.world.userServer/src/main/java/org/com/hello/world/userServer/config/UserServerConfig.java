package org.com.hello.world.userServer.config;

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
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置类
 * @author taohu
 *
 */
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
		log.debug("=================================:数据库连接成功！" + dataSource);
		return dataSource;
		
	}
	
	/**
	 * 创建sqlSessionFactory
	 * @return
	 */
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(environment.getProperty("mybatis.config")));
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
		try {
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));
			log.debug("=============================:sqlSessionFactory创建成功");
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("=============================:sqlSessionFactory创建失败:" + e.getMessage());
		}
		return null;
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
