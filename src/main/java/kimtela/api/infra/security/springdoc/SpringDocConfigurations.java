package kimtela.api.infra.security.springdoc;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Kimura api")
                        .description("API Rest da aplicação Kimura-API, contendo as funcionalidades de CRUD de pessoas, " +
                                "capturando dados que são importante em um currículo para guardar em um banco com objetivo de conseguir um empregp")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("msportela2@hotmail.com")
                                        .url("https://wa.me/61986210645?text=Tenho%20perguntas%20sobre%20a%20API%20kimura")
                                )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://kimura/api/licenca")));
    }


}
