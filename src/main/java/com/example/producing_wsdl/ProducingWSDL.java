package com.example.producing_wsdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProducingWSDL extends SpringBootServletInitializer {//برای اینکه پروژه بصورت tomcat بالا بیاد حتما باید از این کلاس ارث بری شود

	public static void main(String[] args) {
		SpringApplication.run(ProducingWSDL.class, args);
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**            Tara producing soap web service is ready                  **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");



	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProducingWSDL.class);
	}
}
