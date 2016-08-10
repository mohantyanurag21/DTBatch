package com.niit.shoppingkart.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.dao.CategoryDAOImpl;
import com.niit.shoppingkart.model.Cart;
import com.niit.shoppingkart.model.Category;
import com.niit.shoppingkart.model.Product;
import com.niit.shoppingkart.model.Supplier;
import com.niit.shoppingkart.model.User;
import com.niit.shoppingkart.model.UserDetails;

@Configuration
@ComponentScan("com.niit.shopingkart")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/cart");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("update", "hibernate.hbm2ddl.auto");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
    	sessionBuilder.addAnnotatedClasses(Cart.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
    @Autowired
    @Bean(name = "categoryDao")
    public CategoryDAO geCategorDao(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }

	

    
	

}
