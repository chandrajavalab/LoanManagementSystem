package com.rabo.loan.management.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.rabo.loan.management" })
public class LoanmanagementSwaggerConfig {

	public static final Logger log = LoggerFactory.getLogger(LoanmanagementSwaggerConfig.class);
	
	@Bean
	public Docket loanManagementApiDocument() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.rabo.loan.management.")).paths(paths()).build()
				.pathMapping("/").apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Rabo LoanManagement api").description(readswaggerdocument()).version(readVersionInfo()).build();
	}

	private String readVersionInfo() {
		return "version-1001";
	}

	private String readswaggerdocument() {
		StringBuilder builder = new StringBuilder();
		
		try(InputStream inputStream = this.getClass().getResourceAsStream("loanmanagement_swagger_doc.html");
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			int value;
			while((value = reader.read()) != -1) {
				char ch = (char)value;
				builder.append(ch);
			}
			
		} catch (Exception e) {
			log.warn("Prablem of reading swagger document");
		}
		return builder.toString();
	}

	public Predicate<String> paths(){
		return PathSelectors.any();
	}
}
