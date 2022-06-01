import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SecondaryTable(name = "AddressTable")
public class Patient {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(table = "AddressTable")
    private String street;
    @Column(table = "AddressTable")
    private String zip;
    @Column(table = "AddressTable")
    private String city;

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
