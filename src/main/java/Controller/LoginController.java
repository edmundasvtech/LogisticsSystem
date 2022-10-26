package Controller;
import Model.*;
import Services.ViewService;
import Utilities.DriverUtility;
import Utilities.ManagerUtility;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginBtn;
    @FXML
    public PasswordField  passField;;
    @FXML
    public TextField emailField;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");
    ManagerUtility managerUtility = new ManagerUtility(entityManagerFactory);
    DriverUtility driverUtility = new DriverUtility(entityManagerFactory);

    @FXML
    protected void login() throws IOException {
        try {
            if (validateManager()) {openMainMenu();}
                else if (validateDriver()){openDriverMenu();}
                
             else throw new Exception();
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password!");
            alert.showAndWait();

        }

    }

    private void openMainMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home-page.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();
        homeController.loadSystemInfo();
        homeController.setUsername(emailField.getText());
        ViewService.openView((Stage) loginBtn.getScene().getWindow(), root);

    }
    private void openDriverMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("driver-page.fxml"));
        Parent root = loader.load();
        DriverPageController driverPageController= loader.getController();
        driverPageController.loadSystemInfo();
        ViewService.openView((Stage) loginBtn.getScene().getWindow(), root);
    }

    private boolean validateManager() {
        for (Manager manager : managerUtility.getAllManagers()) {
            if (manager.getEmail().equals(emailField.getText()) && manager.getPassword().equals(passField.getText())) {
                return true;
            }
        }
                return false;
            }

            private boolean validateDriver() {
                for (Driver driver : driverUtility.getAllDrivers()) {
                    if (driver.getEmail().equals(emailField.getText()) && driver.getPassword().equals(passField.getText())) {
                        return true;
                    }
                }
                return false;
            }

        }


