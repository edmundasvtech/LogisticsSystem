package Controller;

import Model.Driver;
import Services.ViewService;
import Utilities.LogisticsSystemUtility;
import Model.Reply;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import  com.jfoenix.controls.JFXButton;
import Utilities.DriverUtility;



public class DriversController implements Controller {

    private String text;

    @FXML
    private TableView<Driver> driverList;
    @FXML
    private TableColumn<Driver, String> nameCol;
    @FXML
    private TableColumn<Driver, String> lastNameCol;
    @FXML
    private TableColumn<Driver, String> emailCol;
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
    private Button saveDriverBtn;
    @FXML
    private Button cancelBtn;
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
    @FXML
    private Button removeDriverBtn;


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");
    LogisticsSystemUtility logisticsSystemUtility = new LogisticsSystemUtility(entityManagerFactory);
    DriverUtility driverUtil = new DriverUtility(entityManagerFactory);


    public void loadSystemInfo(){
        loadDrivers();
        ;}

    @FXML

    public void editDriver() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("driveredit-page.fxml"));
        Parent root = loader.load();
        DriverEditorController driverEditorController = loader.getController();
        driverEditorController.setDriversController(this);
        ViewService.newWindow(root, "Add person");
        Driver driver = (Driver) driverList.getSelectionModel().getSelectedItem();
        driverEditorController.setEmailField(driver.getEmail());
        driverEditorController.setPasswordField(driver.getPassword());
        driverEditorController.setNameField(driver.getName());
        driverEditorController.setSurnameField(driver.getSurname());
        driverEditorController.setPhoneNumberField(driver.getPhoneNumber());
        driverEditorController.setDriver(driver);
        updateWindow();
    }
    @FXML
    public void addDriver() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("driveredit-page.fxml"));
        Parent root = loader.load();
        DriverEditorController driverEditorController = loader.getController();
        driverEditorController.setDriversController(this);
        ViewService.newWindow(root, "Add person");
    }
    @FXML
    public void loadDrivers() {
        driverList.getItems().clear();
        final ObservableList<Driver> data = FXCollections.observableArrayList();
        nameCol.setCellValueFactory(new PropertyValueFactory("Name"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("Surname"));
        emailCol.setCellValueFactory(new PropertyValueFactory("Email"));
        driverUtil.getAllDrivers().forEach(reply -> data.add(reply));
        driverList.setItems(data);
        updateWindow();
    }




    @FXML
    public void removeDriver() throws Exception {
        if (driverList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password!");
            alert.showAndWait();
            return;
        }
        Driver driver = (Driver) driverList.getSelectionModel().getSelectedItem();
        driverUtil.destroy(String.valueOf(driver));
        loadDrivers();
    }

    @FXML
    public void updateDriver() {
        if (driverList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password!");
            alert.showAndWait();
            return;
        }
        Driver driver = (Driver) driverList.getSelectionModel().getSelectedItem();
        driver.setEmail(emailField.getText());
        driver.setPassword(passwordField.getText());
        driver.setName(nameField.getText());
        driver.setSurname(surnameField.getText());
        driver.setPhoneNumber(phoneNumberField.getText());
        driverUtil.edit(driver);
    }

    @FXML
    public void openMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home-page.fxml"));
        Parent root = loader.load();

        HomeController homeController = loader.getController();
        ViewService.openView((Stage) homeBtn.getScene().getWindow(), root);
        homeController.loadSystemInfo();
    }
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forum-page.fxml"));
        Parent root = loader.load();

        ForumController forumController= loader.getController();

        ViewService.openView((Stage) forumBtn.getScene().getWindow(), root);
        forumController.loadSystemInfo();
    }

    public void setUserName(String text){
        this.text=text;
    }
    public String returnUsername(){
        return this.text;
    }

    @Override
    public void updateWindow() {
        Stage stage = (Stage) driverList.getScene().getWindow();
        stage.show();
    }

}
