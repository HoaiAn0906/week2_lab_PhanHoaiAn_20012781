package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import www.week2.week02_lab_phanhoaian_20012781.enums.ProductStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="product_id")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @JsonProperty("product_id")
    private long productId;
    @Column(name = "name", length = 150, nullable = false)
    @JsonProperty("name")
    private String name;
    @Column(length = 250, nullable = true)
    @JsonProperty("description")
    private String description;
    @Column(length = 25, nullable = false)
    @JsonProperty("unit")
    private String unit;
    @Column(name = "manufacturer_name", length = 150, nullable = false)
    @JsonProperty("manufacturer")
    private String manufacturer;
    @Column(columnDefinition = "int", nullable = false)
    @JsonProperty("status")
    private ProductStatus status;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonProperty("product_images")
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonProperty("product_prices")
    private List<ProductPrice> productPrices;

    public Product(long productId) {
        this.productId = productId;
    }

    public Product() {
    }
}
