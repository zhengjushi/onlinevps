package com.gdss.onlinevpsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.gdss.onlinevpsystem.controller"})
public class SwaggerConfig {

    @Bean
    public Docket customDocket(){return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());}

    public ApiInfo apiInfo(){
        Contact contact = new Contact("juju","http://www.baidu.com","15706639196@163.com");
        return new ApiInfoBuilder().title("sell项目API接口").description("API接口").contact(contact).version("1.1.0").build();
    }
}
