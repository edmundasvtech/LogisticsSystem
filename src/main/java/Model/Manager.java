package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor


public class Manager extends User implements Serializable {

//    private ArrayList<Driver> myDrivers;
    //  private ArrayList<Trip> currentTrips;

    public Manager(String email, String password, String name, String surname, String phoneNumber, String employmentDate, String birthDate, String completedTrips) {
        super(email, password, name, surname, phoneNumber,  employmentDate, birthDate, completedTrips);

    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }
}

