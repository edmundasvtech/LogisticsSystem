module com.example.logisticssystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.java;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires javafx.base;

    requires com.jfoenix;
    requires org.kordamp.ikonli.javafx;
    opens Controller to javafx.fxml;
    exports Controller;
    exports Model to org.hibernate.orm.core;
    opens Model to org.hibernate.orm.core, javafx.base;


}