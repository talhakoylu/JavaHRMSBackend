package net.ahmettalha.javahrmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan("net.ahmettalha.javahrmsbackend.entities.concretes")
@EnableJpaRepositories(basePackages = {"net.ahmettalha.javahrmsbackend.dataAccess.abstracts"})
public class JavaHrmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaHrmsBackendApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.ahmettalha.javahrmsbackend"))
                .build();
    }
}
