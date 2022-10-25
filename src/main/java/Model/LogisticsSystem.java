package Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class LogisticsSystem implements Serializable {

    @Id
    private long id;

    private String company;

    private LocalDate dateCreated;

    private String version;

    public LogisticsSystem() {

    }

    public LogisticsSystem(Long id, String company, LocalDate dateCreated, String version) {
        this.id = id;
        this.company = company;
        this.dateCreated = dateCreated;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
