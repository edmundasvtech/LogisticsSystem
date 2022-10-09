package Model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Trip {
    ArrayList<Stop> stops;
    ArrayList<Order> orders;
    String startLocation;
    String destination;
    LocalDateTime started;
    LocalDateTime finished;
    SimpleDateFormat totalTime;
    int Distance;
    enum Status{};

    public Trip(Driver assignedDriver, Truck assignedTruck, ArrayList<Stop> stops, ArrayList<Order> orders, String startLocation, String destination, LocalDateTime started, LocalDateTime finished, SimpleDateFormat totalTime, int distance, boolean isCompleted) {

        this.stops = stops;
        this.orders = orders;
        this.startLocation = startLocation;
        this.destination = destination;
        this.started = started;
        this.finished = finished;
        this.totalTime = totalTime;
        Distance = distance;
    }




}

class Stop{
    String location;
    String comment;
    LocalDateTime started;
    LocalDateTime ended;
    SimpleDateFormat totalTime;

    public Stop(String location, String comment, LocalDateTime started, LocalDateTime ended, SimpleDateFormat totalTime) {
        this.location = location;
        this.comment = comment;
        this.started = started;
        this.ended = ended;
        this.totalTime = totalTime;
    }

}
