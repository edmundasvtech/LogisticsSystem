package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public PasswordField  passField;;
    public TextField emailField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void validate() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}