package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail implements Serializable {
    //order_id, product_id, quantity , price, note
    @Id
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonIgnoreProperties("orderDetails")
    private Order orders;
    @Id
    @OneToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    private double quantity;
    private double price;
    @Column(length = 250, nullable = true)
    private String note;
}
