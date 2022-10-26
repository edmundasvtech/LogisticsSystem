package Controller;

import Services.ViewService;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class SidebarController {
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton forumBtn;
    @FXML
    private JFXButton driversBtn;
    @FXML
    private JFXButton myprofileBtn;
    @FXML
    private JFXButton tripsBtn;
    @FXML
    private JFXButton ordersBtn;

    @FXML
    public void openTrips() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trips-page.fxml"));
        Parent root = loader.load();

        TripsController tripsController = loader.getController();

        ViewService.openView((Stage) tripsBtn.getScene().getWindow(), root);
        tripsController.loadSystemInfo();

    }

    @FXML
    public void openOrders() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orders-page.fxml"));
        Parent root = loader.load();

        OrdersController ordersController = loader.getController();

        ViewService.openView((Stage) ordersBtn.getScene().getWindow(), root);
        ordersController.loadSystemInfo();
    }

    @FXML
    public void openMyProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("myprofile-page.fxml"));
        Parent root = loader.load();

        MyProfileController myProfileController = loader.getController();

        ViewService.openView((Stage) myprofileBtn.getScene().getWindow(), root);
        myProfileController.loadSystemInfo();
    }

    @FXML
    public void openDrivers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("driversmanager-page.fxml"));
        Parent root = loader.load();

        DriversController driversController = loader.getController();

        ViewService.openView((Stage) driversBtn.getScene().getWindow(), root);
        driversController.loadSystemInfo();
    }

    @FXML
    public void openForum() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orders-page.fxml"));
        Parent root = loader.load();

        ForumController forumController= loader.getController();

        ViewService.openView((Stage) forumBtn.getScene().getWindow(), root);
        forumController.loadSystemInfo();
    }
}
