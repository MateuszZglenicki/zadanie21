package pl.javastart.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepository {

    private final Set<Product> products;

    private ProductRepository() {
        products = new HashSet<>();
        products.add(new Product("Domestos", 12.50, ProductCategory.OTHER));
        products.add(new Product("czajnik", 79.99, ProductCategory.AGD));
        products.add(new Product("szampon", 9.89, ProductCategory.OTHER));
        products.add(new Product("masło", 7.89, ProductCategory.FOOD));
        products.add(new Product("chleb", 4.89, ProductCategory.FOOD));
        products.add(new Product("szklanka", 5.29, ProductCategory.AGD));
        products.add(new Product("mydło", 2.5, ProductCategory.OTHER));
        products.add(new Product("mydło", 2.5, ProductCategory.OTHER));
    }

    public Set<Product> findByCategory(ProductCategory category) {
        Set<Product> result = new HashSet<>();
        for (Product product : products) {
            if (category == product.getCategory()) {
                result.add(product);
            }
        }
        return result;
    }

    public void add(Product product) {
        products.add(product);
    }

    public Set<Product> findAll() {
        return products;
    }

}
