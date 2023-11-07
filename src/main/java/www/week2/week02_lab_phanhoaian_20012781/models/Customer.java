package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    @JsonProperty("cust_id")
    private long custId;
    @Column(name = "cust_name", length = 150, nullable = false)
    @JsonProperty("cust_name")
    private String custName;
    @Column(unique = true, length = 150)
    @JsonProperty("email")
    private String email;
    @Column(length = 15, nullable = false)
    @JsonProperty("phone")
    private String phone;
    @Column(length = 250, nullable = false)
    @JsonProperty("address")
    private String address;
    @OneToMany(mappedBy = "customers", fetch = FetchType.EAGER)
    @JsonProperty("orders")
    private List<Order> orders;
}
