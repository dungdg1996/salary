package com.vnpt.salary;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import static com.vnpt.salary.SalaryUIApplication.StageReadyEvent;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    @Value("Bang cham cong")
    private String appTitle;
    @Value("classpath:/app.fxml")
    private Resource appContent;
    private final ApplicationContext applicationContext;

    public StageInitializer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try{
            Stage stage = event.getStage();
            stage.setTitle(appTitle);
            FXMLLoader loader = new FXMLLoader(appContent.getURL());
            loader.setControllerFactory(applicationContext::getBean);
            Parent parent = loader.load();
            assert parent != null;
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
