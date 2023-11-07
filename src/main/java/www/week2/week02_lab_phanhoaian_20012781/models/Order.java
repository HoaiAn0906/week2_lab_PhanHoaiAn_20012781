package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="order_id")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonProperty("order_id")
    private long orderId;
    @Column(name = "order_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name="emp_id", nullable=false)
    @JsonProperty("employees")
    private Employee employees;
    @ManyToOne
    @JoinColumn(name="cust_id", nullable=false)
    @JsonProperty("customers")
    private Customer customers;

    public Order(long orderId, LocalDate dob, Employee employees, Customer customers) {
        this.orderId = orderId;
        this.dob = dob;
        this.employees = employees;
        this.customers = customers;
    }

    public Order() {
    }
}
