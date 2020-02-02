package org.jonas.jontability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
