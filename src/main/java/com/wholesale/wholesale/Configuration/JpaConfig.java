package com.wholesale.wholesale.Configuration;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.wholesale.wholesale.infrastructure.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "com.wholesale.wholesale.Domain.Entities")
public class JpaConfig {
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        // Criar o adaptador do fornecedor JPA para o Hibernate
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); // Habilita a geração de DDL (se necessário)
        vendorAdapter.setShowSql(true); // Exibe as consultas SQL no console

        // Criar o bean de EntityManagerFactory
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);  // Configura o DataSource
        factoryBean.setJpaVendorAdapter(vendorAdapter);  // Configura o adaptador
        factoryBean.setPackagesToScan("com.wholesale.wholesale.Domain.Entities"); // Pacote das entidades
        factoryBean.setPersistenceUnitName("jpa"); // Nome da unidade de persistência

        return factoryBean;
    }
}
