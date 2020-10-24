package com.vnpt.salary.cofig;

import com.vnpt.salary.utils.ViewMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {
    @Value("classpath:/fxml/home.fxml")
    private Resource homePage;

    @Bean
    public ViewMode viewMode(){
        return new ViewMode();
    }

    @Bean
    public StorageProperties storageProperties(){
        return new StorageProperties();
    }
}
