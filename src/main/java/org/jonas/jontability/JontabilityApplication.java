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

import java.util.Date;

@SpringBootApplication
public class JontabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JontabilityApplication.class, args);
	}
}
