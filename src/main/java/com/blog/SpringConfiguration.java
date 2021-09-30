package com.blog;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.blog.entity.Admin;
import com.blog.entity.Comment;
import com.blog.entity.Customer;
import com.blog.entity.Hashtag;
import com.blog.entity.Post;
import com.blog.entity.Posthash;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.blog"})
@PropertySource(value = {"classpath:db.properties"})
public class SpringConfiguration implements WebMvcConfigurer{
	@Autowired
	Environment enviroment;
	
	@Bean
	public Admin admin() {
		Admin admin = new Admin();
		return admin;
	}
	
	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		return customer;
	}
	
	@Bean
	public Hashtag hashtag() {
		Hashtag hashtag = new Hashtag();
		return hashtag;
	}

	@Bean
	public Post post() {
		Post post = new Post();
		return post;
	}
	
	@Bean
	public Comment comment() {
		Comment comment = new Comment();
		return comment;
	}
	
	@Bean
	public Posthash posthash() {
		Posthash posthash= new Posthash();
		return posthash;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("driver"));
		dataSource.setUrl(enviroment.getProperty("url"));
		dataSource.setUsername("root");
		dataSource.setPassword(enviroment.getProperty("password"));
		return dataSource;
	}	
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
