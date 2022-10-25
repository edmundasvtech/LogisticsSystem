package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    public PasswordField passField;;
    @FXML
    public TextField emailField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void validate() {

        welcomeText.setText(emailField.getText());
        System.out.println(emailField.getText());
    }
}
