package levelUp.main.LevelUp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MiniProduct {

    private long idProduct;
    private String nameProduct;
    private String categoryProduct;
    private String distributorProduct;
    private String linkDistributor;
    private int priceProduct;
    private String urlImage;
}
