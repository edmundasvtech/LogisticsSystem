package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Forum {
    private String ID;

    private LocalDate dateCreated;
    private String title;
    private ArrayList<Category> Categories;
    private void addCategory(String title, String description) {
        Category category= new Category(title, description);
        this.Categories.add(category);
    }

}
class Category{
    private String ID;
    private String title;
    private String description;
    private ArrayList<Thread> Threads;
    private LocalDateTime dateCreated;
    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }
    private void addThread(String title, String text, String author, SimpleDateFormat date){
            Thread thread = new Thread(title, text, author, date);
            this.Threads.add(thread);
    }
}
class Thread{

    private String ID;
    private String title;
    private String author;
    private String text;
    private LocalDate dateCreated;
    private ArrayList<Reply> replies;
    public Thread(String title, String text, String author, SimpleDateFormat date) {
        this.title = title;
        this.text = text;
    }
    public void addReply(String text, String author, SimpleDateFormat date){
        Reply reply=new Reply(text, author, date);
        this.replies.add(reply);
    }
}
class Reply{
    private String ID;
    private String author;
    private String text;
    private SimpleDateFormat dateCreated;

    public Reply(String text, String author, SimpleDateFormat date) {
        this.text = text;
        this.author = author;
        this.dateCreated = date;
    }
}
