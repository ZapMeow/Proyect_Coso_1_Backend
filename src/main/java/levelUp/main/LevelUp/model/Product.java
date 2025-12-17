package levelUp.main.LevelUp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
@Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product") private long idProduct;
    @Column(name = "name_product", length = 40) private String nameProduct;
    @Column(name = "category_product", length = 50) private String categoryProduct;
    @Column(name = "distributor_product", length = 40) private String distributorProduct;
    @Column(name = "link_distributor", length = 100) private String linkDistributor;
    @Column(name = "price_product", length = 10) private int priceProduct;
    @Column(name = "description_product", length = 300) private String descriptionProduct;
    @Column(name = "url_product", length = 500) private String urlImage;
    @Column(name = "stock_product", length = 5) private int stockProduct;
}
