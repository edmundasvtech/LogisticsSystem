package Controller;

import Model.Reply;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import Utilities.MessageUtility;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DriverPageController {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LogisticsSystem");


    @FXML
    private ListView latestMessages;
    @FXML
    private PieChart pieChart;
    public void loadSystemInfo(){

            System.out.println("x");
    }



    public void updateWindow() {
        Stage stage = (Stage) latestMessages.getScene().getWindow();
        stage.show();
    }
}
