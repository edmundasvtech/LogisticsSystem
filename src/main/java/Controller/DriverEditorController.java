package Controller;

import Model.Driver;
import Utilities.DriverUtility;
import Utilities.LogisticsSystemUtility;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
@Getter
@Setter
public class DriverEditorController implements WindowController {
    private Driver driver;
    private DriversController driversController;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");
    DriverUtility driverUtil = new DriverUtility(entityManagerFactory);
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button addDriverBtn;

    public DriversController getDriversController() {
        return driversController;
    }

    public void setDriversController(DriversController driversController) {
        this.driversController = driversController;
    }
    public void setDriver(Driver driver){
        this.driver=driver;
    }
    @Override
    public void closeWindow() {
        driversController.loadDrivers();
        Stage stage = (Stage) addDriverBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addDriver() throws IOException {
        if (emailField.getText().isEmpty() || passwordField.getText().isEmpty() || nameField.getText().isEmpty() ||
                surnameField.getText().isEmpty() || phoneNumberField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password!");
            alert.showAndWait();
            return;
        }
        if(this.driver==null){
        driversController.driverUtil.create(new Driver(emailField.getText(), passwordField.getText(), nameField.getText(),
                surnameField.getText(), phoneNumberField.getText(), LocalDate.now().toString(),LocalDate.now().toString()));}else if(this.driver!=null){
            driver.setEmail(emailField.getText());
            driver.setPassword(passwordField.getText());
            driver.setName(nameField.getText());
            driver.setSurname(surnameField.getText());
            driver.setPhoneNumber(phoneNumberField.getText());
            driverUtil.edit(driver);

        }
        closeWindow();
    }
    void setEmailField(String email){
        this.emailField.setText(email);
    };
    void setPasswordField(String password){
        this.passwordField.setText(password);
    };
    void setNameField(String name){
        this.nameField.setText(name);
    };
    void setSurnameField(String surname){
        this.surnameField.setText(surname);
    };
    void setPhoneNumberField(String phoneNumber){
        this.phoneNumberField.setText(phoneNumber);
    }

}
