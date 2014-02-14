package ar.example.ws.config;

import javax.sql.DataSource;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "ar.example" })
@EnableTransactionManagement
@ComponentScan(basePackages = { "ar.example" })
@XSlf4j
public class ApplicationConfiguration {

	@Bean
	public DataSource dataSource() {
		log.info("HSQL DataSource");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setName("jpaTestDb").setType(EmbeddedDatabaseType.HSQL).build();

		// org.apache.commons.dbcp.BasicDataSource ds = new
		// org.apache.commons.dbcp.BasicDataSource();
		// ds.setDriverClassName("org.hsqldb.jdbcDriver");
		// ds.setUrl("jdbc:hsqldb:mem:target/wsdb");
		// ds.setUsername("sa");
		// ds.setPassword("");
		// return (DataSource) ds;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		log.info("Setting the LocalContainerEntityManagerFactoryBean  ");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setPackagesToScan("ar.example");

		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		log.info("JPA Vendor adapter ");
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}
