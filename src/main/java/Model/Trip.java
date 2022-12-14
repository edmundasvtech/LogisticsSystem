package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {
    ArrayList<Stop> stops;
    ArrayList<Order> orders;
    String startLocation;
    String currentLocation;
    String destination;
    LocalDateTime started;
    LocalDateTime finished;
    SimpleDateFormat totalTime;
    int Distance;
    enum Status{};


}

