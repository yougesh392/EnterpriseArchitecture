import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "TYPE")
    private String doctortype;
    private String firstName;
    private String lastName;

    public Doctor(String doctortype, String firstName, String lastName) {
        this.doctortype = doctortype;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
