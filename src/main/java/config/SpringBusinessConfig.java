package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@ComponentScan(basePackageClasses = SpringBusinessConfig.class)
@ComponentScan({"entity", "model.services", "model.impl", "manager"})
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class SpringBusinessConfig {
	
    /*
     * Définition de la source de données
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("203762_annuaire");
        dataSource.setPassword("jee_bs_projet_users");
        dataSource.setUrl("jdbc:mysql://mysql-fallouseye.alwaysdata.net:3306/fallouseye_jee_projet_m1_annuaire_barakat_seye");
        return dataSource;
    }

    /*
     * Construction de l'entityManagerFactory à partir de la source de données et du
     * choix d'hibernate. Cette configuration remplace le fichier persistence.xml
     */
    @Bean(name = "myData")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(//
            @Autowired DataSource ds) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ds);
        em.setPackagesToScan(new String[] { "myapp.business" , "model.services" , "model.impl" , "entity", "manager"}); 
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setBeanName("myData");
        // Configuration d'hibernate
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        em.setJpaProperties(properties);
        return em;
    }

    /*
     * Construction d'un gestionnaire de transaction en liaison avec l'usine à EM.
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /*
     * Activer le traitement des annotations de gestion du contexte de persistence.
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor annotationProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

}