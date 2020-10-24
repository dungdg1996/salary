package com.vnpt.salary.view;

import com.vnpt.salary.service.AuthService;
import javafx.stage.Stage;

public class ChangePasswordDialog extends Stage {
    private AuthService authService;

    public ChangePasswordDialog(AuthService authService) {
        this.authService = authService;
    }
}
