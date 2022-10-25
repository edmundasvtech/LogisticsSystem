package Model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Driver extends User implements Serializable {
//  private Trip currentTrip;
    //   private Truck currentTruck;

    public Driver(String email, String password, String name, String surname, String phoneNumber,  String employmentDate, String birthDate, String completedTrips ) {
        super(email, password, name, surname, phoneNumber,  employmentDate, birthDate, completedTrips);

}
    @Override
    public String getEmail() {
        return super.getEmail();
    }

}
