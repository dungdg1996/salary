package com.vnpt.salary.controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.springframework.stereotype.Component;

@Component
public class AppController {
    @FXML
    public WebView webView;
    @FXML
    public void initialize(){
        WebEngine engine = webView.getEngine();
        engine.load("http://localhost:8080/users");
    }
}
