package com.bus.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Juan Diego Alosilla Lajo", "https://www.instagram.com/diegoalosilla/",
			"diegoalosilla@gmail.com");
	@SuppressWarnings("rawtypes")
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Servicio Alternativo de Buses UPC", "La UPC pone a disposición de los alumnos, docentes y personal administrativo un servicio alternativo de buses para desplazarse por fines académicos, extraacadémicos y administrativos, desde el Campus Villa hacia el Campus Monterrico, Campus San Isidro y Campus San Miguel, y viceversa.", "1.0",
			"FREE", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);

	}
}