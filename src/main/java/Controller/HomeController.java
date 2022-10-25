package Controller;

import Utilities.LogisticsSystemUtility;
import Model.Reply;
import Utilities.MessageUtility;
import Controller.LatestMessagesTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import  com.jfoenix.controls.*;
import org.kordamp.ikonli.javafx.StackedFontIcon;




public class HomeController implements Controller {

    private String text;
    @FXML
    private TextField companyTextField;

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


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");
    LogisticsSystemUtility logisticsSystemUtility = new LogisticsSystemUtility(entityManagerFactory);
    MessageUtility messageUtility = new MessageUtility(entityManagerFactory);

    @Override
    public void updateWindow() {
        loadSystemInfo();
        Stage stage = (Stage) companyTextField.getScene().getWindow();
        stage.show();
    }
    public void loadSystemInfo(){
            populateLatestMessagesTable();
 }
    public void populateLatestMessagesTable() {
        /*
        latestMessagesTable.getItems().clear();

            final ObservableList<Reply> data = FXCollections.observableArrayList();
            authorCol.setCellValueFactory(new PropertyValueFactory("author"));
            textCol.setCellValueFactory(new PropertyValueFactory("text"));
           dateCreatedCol.setCellValueFactory(new PropertyValueFactory("dateCreated"));
            messageUtility.getAllReplies().forEach(reply -> data.add(reply));
            latestMessagesTable.setItems(data);*/

    }

    @FXML
    public void loadLatestMessages() {

    }


}
