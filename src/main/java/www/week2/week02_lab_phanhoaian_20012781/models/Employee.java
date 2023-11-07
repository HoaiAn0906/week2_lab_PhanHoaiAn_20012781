package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;
import www.week2.week02_lab_phanhoaian_20012781.enums.EmployeeStatus;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "Employee.findAll", query = "from Employee"),
})
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="emp_id")
@ToString()
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",length = 20)
    @JsonProperty("emp_id")
    private long id;
    @Column(name = "full_name",nullable = false,length = 150)
    @JsonProperty("full_name")
    private String fullName;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date dob;
    @Column(nullable = false,length = 150,unique = true)
    @JsonProperty("email")
    private String email;
    @Column(nullable = false,length = 15)
    @JsonProperty("phone")
    private String phone;
    @Column(nullable = false,length = 250)
    @JsonProperty("address")
    private String address;
    @Column(nullable = false,length = 11)
    @JsonProperty("status")
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employees",fetch = FetchType.EAGER)
    @JsonProperty("orders")
    private List<Order> orders;

    public Employee(String fullName, Date dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {
    }
}