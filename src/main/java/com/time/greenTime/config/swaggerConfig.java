package com.time.greenTime.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class swaggerConfig {
	public Docket apis() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.time.greenTime")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfomation());
	}

	private ApiInfo apiInfomation() {
		return new ApiInfoBuilder().title("GreenTime Application").description("GreenTime API ").build();
	}
}
