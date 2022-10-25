package Model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@MappedSuperclass
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String employmentDate;
    private String birthDate;
    private String completedTrips;
    public User(String email, String password, String name, String surname, String phoneNumber, String employmentDate, String birthDate, String completedTrips) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber=phoneNumber;
        this.employmentDate=employmentDate;
        this.birthDate=birthDate;
        this.completedTrips=completedTrips;
    }


}

