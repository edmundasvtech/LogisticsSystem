package Controller;

import Utilities.LogisticsSystemUtility;
import Model.Reply;
import Utilities.MessageUtility;
import Services.ViewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  com.jfoenix.controls.JFXButton;
import org.kordamp.ikonli.javafx.StackedFontIcon;

public class HomeController implements Controller {
    @FXML
    private Label userName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField versionTextField;
    @FXML
    private PieChart pieChart;
    @FXML
    private TableView latestMessagesTable;
    @FXML
    private TableColumn<Reply, String> authorCol;
    @FXML
    private TableColumn<Reply, String> textCol;
    @FXML
    private TableColumn<Reply, LocalDate> dateCreatedCol;
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

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");
    LogisticsSystemUtility logisticsSystemUtility = new LogisticsSystemUtility(entityManagerFactory);
    MessageUtility messageUtility = new MessageUtility(entityManagerFactory);

    public void loadSystemInfo(){
    populateLatestMessagesTable();}
    public void setUsername(String text){
        this.userName.setText(" "+text+"!");
    }
    public void populateLatestMessagesTable() {
        latestMessagesTable.getItems().clear();
        final ObservableList<Reply> data = FXCollections.observableArrayList();
        authorCol.setCellValueFactory(new PropertyValueFactory("author"));
        textCol.setCellValueFactory(new PropertyValueFactory("text"));
        dateCreatedCol.setCellValueFactory(new PropertyValueFactory("dateCreated"));
        messageUtility.getAllReplies().forEach(reply -> data.add(reply));
        latestMessagesTable.setItems(data);}

    @FXML
    public void loadLatestMessages() {}
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
    @Override
    public void updateWindow() {
        loadSystemInfo();
    }
}
