import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;


@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Payment {
    private String paydate;
    private double ammount;

    public Payment(String paydate, double ammount) {

        this.paydate = paydate;
        this.ammount = ammount;
    }
}
