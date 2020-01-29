package org.jonas.jontability;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.catalina.filters.RemoteIpFilter;
import org.jonas.jontability.Mapper.BillMapper;
import org.jonas.jontability.dto.BillDto;
import org.jonas.jontability.entities.BillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@SpringBootApplication
public class JontabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JontabilityApplication.class, args);
	}


//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/restapi/category").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
}
