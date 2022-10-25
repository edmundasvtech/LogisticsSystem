package Controller;

import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class LatestMessagesTable {

    private SimpleStringProperty id = new SimpleStringProperty();
    private SimpleStringProperty author = new SimpleStringProperty();
    private SimpleStringProperty text = new SimpleStringProperty();
    private SimpleStringProperty dateCreated = new SimpleStringProperty();

    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }

    public String getAuthor() {
        return author.get();
    }
    public void setAuthor(String author) {
        this.author.set(author);
    }
    public void setText(String text) {
        this.text.set(text);
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getText() {
        return text.get();
    }

    public String getdateCreated() {
        return dateCreated.get();
    }

}