package com.intel.statsapplication.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	
	
	public Docket productApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("com.intel.statsapplication")))
				.paths(paths())
				.build().apiInfo(metadata());
	}
	private Predicate<String> paths() {
	    return or(
	            regex("/api/stats"),
	            regex("/api/calculations"),
	            regex("/api/math"));
	}

	private ApiInfo metadata() {
	    return new ApiInfoBuilder()
	            .title("Api")
	            .description("Intel Api")
	            .build();
	}
	}


