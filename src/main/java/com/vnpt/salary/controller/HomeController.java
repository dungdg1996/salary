package com.vnpt.salary.controller;

import com.vnpt.salary.entity.User;
import com.vnpt.salary.service.AuthService;
import com.vnpt.salary.service.StorageService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
    private final AuthService authService;
    private final StorageService storageService;

    @FXML
    private Circle avatar;
    @FXML
    private Label name;

    public HomeController(AuthService authService, StorageService storageService) {
        this.authService = authService;
        this.storageService = storageService;

    }

    public void init() {
        User user = authService.getPrincipal();
        if (user == null){
            Platform.exit();
        }
        try {
            assert user != null;
            Resource resource = storageService.loadAsResource(user.getAvatar());
            avatar.setFill(new ImagePattern(new Image(resource.getInputStream())));
            name.setText(user.getFullName());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void hide(MouseEvent event) {
        Stage w = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (w.isShowing()) {
            w.setIconified(true);
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void clickHandle(MouseEvent event) {
        String id = ((Node) event.getSource()).getId();
        switch (id){
            case "dash_board":
                break;
            case "bang_cham_cong":
                break;
        }
    }
}
