package com.ambcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class AbmcardRESTApplication {

    public static void main(String[] args) {

        SpringApplication.run(AbmcardRESTApplication.class, args);

    }
}
