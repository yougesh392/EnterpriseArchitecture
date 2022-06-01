import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter  @Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    private String appdate;
    @Embedded
    private Payment payment;
    @OneToOne
    @JoinColumn(name = "PATIENT")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;

    public Appointment(String appdate, Patient patient, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.doctor = doctor;
    }
}
