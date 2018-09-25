package com.exam.demo.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger2的配置类  这个是必须要有的
 * creator syg
 * 2018-9-25
 */
@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)//告诉他我选择的是2.0的版本
                .groupName("syg使用的api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.exam.demo.controller"))///扫描cn.syg路径下的api文档
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }

    //其实的话多写几个bean的话也就可以进行分组了  其实的话就是加上groupName参数而已
    @Bean
    public Docket openApi() {
        return new Docket(DocumentationType.SWAGGER_2)//告诉他我选择的是2.0的版本
                .groupName("syg使用的开放api")
                .apiInfo(apiInfo1())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.open"))
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo1() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档2222open")
                .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }

}