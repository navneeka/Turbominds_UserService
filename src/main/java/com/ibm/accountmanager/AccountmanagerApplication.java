package com.ibm.accountmanager;

import java.util.List;
import java.util.Optional;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"com.ibm.accountmanager.entity"} )
@EnableJpaRepositories(basePackages = {"com.ibm.accountmanager.repository"})
@ComponentScan(basePackages = { "com.ibm.accountmanager.*"})
public class AccountmanagerApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AccountmanagerApplication.class, args);
		ctx.registerShutdownHook();
	}
	
	@PreDestroy
	void cleanUp() {
		
	}
	
	@Override
	public final void extendMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        //get json converter from default converter list
        Optional<HttpMessageConverter<?>> converterOptional = converters.stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findFirst();
        // remove from current position
        converterOptional.ifPresent(converters::remove);
        //add as default at first place
        converterOptional.ifPresent(jsonConverter -> converters.add(0, jsonConverter));
    }
}

