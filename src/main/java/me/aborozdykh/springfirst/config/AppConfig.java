package me.aborozdykh.springfirst.config;

import java.util.Properties;
import javax.sql.DataSource;
import me.aborozdykh.springfirst.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = {
        "me.aborozdykh.springfirst.service",
        "me.aborozdykh.springfirst.dao"
})
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cinema?serverTimezone=UTC");
        dataSource.setUsername("internetshop");
        dataSource.setPassword("Qwerty1@");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        var factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        var properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }
}
