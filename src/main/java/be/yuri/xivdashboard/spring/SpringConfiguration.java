package be.yuri.xivdashboard.spring;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"be.yuri.xivdashboard"})
@EnableTransactionManagement
public class SpringConfiguration {  
	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("be.vacancesvivantes.formation.data","be.vacancesvivantes.formation.repository");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}


	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", MySQL5Dialect.class.getName());
		properties.put("hibernate.connection.useUnicode", true);
		properties.put("hibernate.connection.charSet", "UTF-8");
		properties.put("hibernate.connection.characterEncoding", "utf8");
		//properties.put("hibernate.show_sql",true);
		return properties;
	}


	@Bean
	public DataSource dataSource() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource("jdbc:mariadb://localhost:3306/formation?useUnicode=yes&amp;characterEncoding=utf-8", "root", "toor123", true);
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		return ds;
	}
*/
}
