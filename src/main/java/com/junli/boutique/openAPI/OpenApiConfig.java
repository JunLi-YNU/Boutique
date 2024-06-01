package com.junli.boutique.openAPI;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * @program: boutique
 * @description: Swagger接口管理描述
 * @author: Cageling
 * @created: 2023/07/30 16:26
 */
@Configuration
public class OpenApiConfig {
    public OpenAPI createRestfulApi() {
        return new OpenAPI().info(new Info()
                .title("Boutique Project Api")
                .description("Boutique项目Api接口")
                .version("0.0.1")

        );
    }
}
