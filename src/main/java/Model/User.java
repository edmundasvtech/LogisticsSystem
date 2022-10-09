package Model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements Serializable {
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private ArrayList<Trip> completedTrips;


}
class Driver extends User{
    private Trip currentTrip;
    private Truck currentTruck;

    public Driver(int id, String email, String password, String name, String surname, String phoneNumber, LocalDate birthDate, LocalDate employmentDate, ArrayList<Trip> completedTrips ) {
        super(id, email, password, name, surname, phoneNumber, birthDate, employmentDate, completedTrips);
    }
}
class Manager extends User{

    private ArrayList<Driver> myDrivers;
    private ArrayList<Trip> currentTrips;

    public Manager(int id, String email, String password, String name, String surname, String phoneNumber, LocalDate birthDate, LocalDate employmentDate, ArrayList<Trip> completedTrips) {
        super(id, email, password, name, surname, phoneNumber, birthDate, employmentDate, completedTrips);
    }
}
