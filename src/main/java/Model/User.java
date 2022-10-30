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
    protected int id;
    protected String email;
    protected String password;
    protected String name;
    protected String surname;
    protected String phoneNumber;
    protected String employmentDate;
    protected String birthDate;
    public User(String email, String password, String name, String surname, String phoneNumber, String employmentDate, String birthDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber=phoneNumber;
        this.employmentDate=employmentDate;
        this.birthDate=birthDate;
    }


}

