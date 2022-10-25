package com.optimagrowth.organization;

import com.optimagrowth.organization.utils.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RefreshScope
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@SuppressWarnings("unchecked")
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate template = new RestTemplate();
		List interceptors = template.getInterceptors();
		if (interceptors==null){
			template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
		}
		else{
			interceptors.add(new UserContextInterceptor());
			template.setInterceptors(interceptors);
		}

		return template;
	}
}
