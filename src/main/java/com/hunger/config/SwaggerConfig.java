package com.hunger.config;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.hunger.HungerApiJavaApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(HungerApiJavaApplication.class.getPackage().getName())).build().apiInfo(apiInfo())
                .useDefaultResponseMessages(false).genericModelSubstitutes(ResponseEntity.class)
                .directModelSubstitute(ObjectId.class, String.class).tags(new Tag("Specialties", "Specialties is professional"))
                .tags(new Tag("Professional", "Professional Management"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Hunger - Consultório").build();
    }

}
