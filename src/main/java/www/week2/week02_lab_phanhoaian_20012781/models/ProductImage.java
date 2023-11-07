package www.week2.week02_lab_phanhoaian_20012781.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "product_images")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="image_id")

public class ProductImage implements Serializable {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("image_id")
    private long  imageId;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    @JsonProperty("product")
    private Product product;
    @Column(length = 250, nullable = false)
    @JsonProperty("path")
    private String path;

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
