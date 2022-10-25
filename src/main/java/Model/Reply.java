package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;
@Data
@Entity
@Getter
@Setter
public class Reply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String author;
    private String text;
    private LocalDate dateCreated;



    public Reply(){}

    public Reply(String author, String text, LocalDate date) {
        this.author = author;
        this.text = text;
        this.dateCreated = date;

    }

    public long getId() {return id;}
    public String getAuthor() {return author;}
    public String getText() {return text;}
    public LocalDate getDate() {return dateCreated;}

    public void setAuthor(String author) {this.author = author;}
    public void setText(String text) {this.text = text;}
    public void setDate(LocalDate date) { this.dateCreated = date;}


}
