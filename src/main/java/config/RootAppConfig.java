package config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class RootAppConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ds.setUser("scott");
			ds.setPassword("tiger");
			ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=TableGame");
			ds.setInitialPoolSize(3);
			ds.setMaxPoolSize(6);
			ds.setMaxIdleTime(3500);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan(new String[]{"model"});
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return localSessionFactoryBean;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		properties.put("hbm2ddl.auto", "update");
		properties.put("show_sql", "true");
		properties.put("format_sql", "true");
		properties.put("hibernate.transaction.coordinator_class", "jdbc");
		properties.put("hibernate.bytecode.use_reflection_optimizer", "false");
		properties.put("connection_pool_size", "8");
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}
