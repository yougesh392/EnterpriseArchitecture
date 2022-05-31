import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private long id;
    private long quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public OrderLine() {
    }

    public OrderLine(long quantity,Product product) {
        this.product = product;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
