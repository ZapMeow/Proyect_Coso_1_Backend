package levelUp.main.LevelUp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import levelUp.main.LevelUp.model.MiniProduct;
import levelUp.main.LevelUp.model.Product;
import levelUp.main.LevelUp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Hola", description = "Aqui hay APIs")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getClientProducts")
    public List<MiniProduct> getClientProducts(){
        List<MiniProduct> miniProducts = new ArrayList<>();
        List<Product> products = productService.allProducts();

        for (Product product : products){
            miniProducts.add(new MiniProduct(product.getIdProduct(), product.getNameProduct(), product.getCategoryProduct(), product.getDistributorProduct(), product.getLinkDistributor(), product.getPriceProduct(), product.getUrlImage()));
        }

        return miniProducts;
    }

    @GetMapping("/getAllProducts")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAllBooks(){
        return productService.allProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Product getProductById(@PathVariable long id){
        return productService.findProductById(id);
    }

    @GetMapping("/getAdminProductById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product getAdminProductById(@PathVariable long id){
        return productService.findProductById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product saveProduct(@RequestBody Product newProduct){
        return productService.saveProduct(newProduct);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@PathVariable long id, @RequestBody Product productToChange){
        Product currentProduct = productService.findProductById(id);
        if (currentProduct != null){
            currentProduct.setDescriptionProduct(productToChange.getDescriptionProduct());
            currentProduct.setNameProduct(productToChange.getNameProduct());
            currentProduct.setPriceProduct(productToChange.getPriceProduct());
            currentProduct.setStockProduct(productToChange.getStockProduct());
            currentProduct.setUrlImage(productToChange.getUrlImage());
            currentProduct.setCategoryProduct(productToChange.getCategoryProduct());
            currentProduct.setDistributorProduct(productToChange.getDistributorProduct());
            currentProduct.setLinkDistributor(productToChange.getLinkDistributor());

            productService.saveProduct(currentProduct);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProductById(id);
    }

}
