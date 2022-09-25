package Model;

import java.util.ArrayList;

public class Forum {
    ArrayList<Forum> Category;
}
class Category{
    ArrayList<Thread> Threads;

}
class Thread{

    ArrayList<Reply> replies;
    String text;
}
class Reply{
String text;

}
