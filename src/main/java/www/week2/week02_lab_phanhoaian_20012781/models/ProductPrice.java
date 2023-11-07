package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product_prices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="product_price_id")
public class ProductPrice implements Serializable {
    @Id
    @Column(name = "product_price_id")
    @JsonProperty("product_price_id")
    private long productPriceId;
    @Column(name = "price_date_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date price_date_time;
    @Column(name = "price")
    @JsonProperty("price")
    private double price;
    @Column(name = "note")
    @JsonProperty("note")
    private String note;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    @JsonProperty("product")
    private Product product;
}
