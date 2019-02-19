package com.company.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("sport.properties")
public class SportConfig {
    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){  // Method name is the beanId
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());  // passing above bean to the method
    }

}
