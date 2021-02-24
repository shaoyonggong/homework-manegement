package com.java.homeworkmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Author shaoyonggong
 * @Date 2021/2/24
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.java.homeworkmanagement"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("王子颖毕设Api接口文档")
                        .description("接口详细信息......")
                        .version("9.0")
                        .contact(new Contact("王子颖毕设","com.java.wzy","wangziying@126.com"))
                        .license("The Ziying Wang License")
                        .licenseUrl("http://www.nishishi.com")
                        .build());
    }
}
