module com.example.logisticssystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens Controller to javafx.fxml;
    exports Controller;
}