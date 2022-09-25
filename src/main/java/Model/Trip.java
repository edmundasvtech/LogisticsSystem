package Model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Trip {
    Driver assignedDriver;
    Truck assignedTruck;
    ArrayList<Stop> stops;
    ArrayList<Order> orders;
    String startLocation;
    String destination;
    LocalDateTime started;
    LocalDateTime finished;
    SimpleDateFormat totalTime;
    int Distance;
    boolean isCompleted;
}

class Stop{
    String location;
    String comment;
    LocalDateTime started;
    LocalDateTime ended;
    SimpleDateFormat totalTime;
}