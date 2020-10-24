package com.vnpt.salary.controller;

import com.vnpt.salary.service.AuthService;
import com.vnpt.salary.utils.ViewMode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController {
    private final AuthService authService;
    private final ApplicationContext applicationContext;
    private final ViewMode viewMode;
    @Value("classpath:/fxml/home.fxml")
    private Resource homePage;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public LoginController(AuthService authService, ApplicationContext applicationContext, ViewMode viewMode) {
        this.authService = authService;
        this.applicationContext = applicationContext;
        this.viewMode = viewMode;
    }

    @FXML
    private void submit(ActionEvent event) {
        if (authService.checkLogin(username.getText(), password.getText())){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(homePage.getURL());
                loader.setControllerFactory(applicationContext::getBean);
                Parent parent = loader.load();
                stage.setScene(new Scene(parent));
                viewMode.setCenter(stage);
                viewMode.setDrag(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Đăng nhập không thành công");
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        Platform.exit();
    }
}
