package com.isu.cs309.biditall.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    public static final String PAYMENT_DESCRIPTION_TAG = "Payment-Controller";
    public static final String DATA_FILE_DESCRIPTION_TAG = "DataFile-Controller";

    @Bean
    public Docket myDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.isu.cs309.biditall"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(PAYMENT_DESCRIPTION_TAG, "REST api call for the handling payment information."))
                .tags(new Tag(DATA_FILE_DESCRIPTION_TAG, "REST api call for handling files."));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bid it all")
                .description("Hi developers, this is the api-docs for COM S 309 Bid it All project.")
                .version("0.0.2")
                .build();
    }
}
