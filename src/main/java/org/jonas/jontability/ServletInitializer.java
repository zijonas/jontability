package org.jonas.jontability;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jonas.jontability.dto.BillDto;
import org.jonas.jontability.entities.BillEntity;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Calendar;
import java.util.Date;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(JontabilityApplication.class);
	}



}
