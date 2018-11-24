package code.better.com.config;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import code.better.com.pojo.Student;

@RefreshScope
@Configuration
public class Config {

	@Value("${db.url}")
	private String dbURL;
	@Value("${db.user}")
	private String dbUser;
	@Value("${db.password}")
	private String dbPassword;

	@Bean(name = "serviceThread")
	public ExecutorService getThreadPool() {
		return Executors.newFixedThreadPool(5);
	}

	@Bean(name = "dbPool")
	public DataSource getDbPool() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setAutoCommit(true);
		hikariConfig.setJdbcUrl(dbURL);
		hikariConfig.setUsername(dbUser);
		hikariConfig.setPassword(dbPassword);
		return new HikariDataSource(hikariConfig);

	}

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(@Qualifier("dbPool") DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
		props.put("hibernate.show_sql",true);
		props.put("hibernate.hbm2ddl.auto", "validate");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(Student.class);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(
			@Qualifier("sessionFactory") LocalSessionFactoryBean sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory.getObject());
		return transactionManager;
	}

}
