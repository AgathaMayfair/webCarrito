package webappcarrito.initializer;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("webappcarrito.repositories")
public class PersistanceContext {
	
	@Bean(destroyMethod = "close")
	DataSource datasource(Environment env) {
		
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getProperty("db.driver"));
		dataSourceConfig.setJdbcUrl(env.getProperty("db.url"));
		dataSourceConfig.setUsername(env.getProperty("db.username"));
		dataSourceConfig.setPassword(env.getProperty("db.password"));

		return new HikariDataSource(dataSourceConfig);
		
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, Environment env) {
		
		LocalContainerEntityManagerFactoryBean lceManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		lceManagerFactoryBean.setDataSource(ds);
		lceManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lceManagerFactoryBean.setPackagesToScan("webappcarrito.entities");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.connection.pool_size", env.getProperty("hibernate.connection.pool_size"));
		jpaProperties.put("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));		
		
		lceManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return lceManagerFactoryBean;
		
	} 
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		
		return jpaTransactionManager;
		
	} 

}
