package pl.javastart.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String list(@RequestParam(value = "kategoria", required = false) ProductCategory category, Model model) {
        Set<Product> products;
        if (category != null) {
            products = productRepository.findByCategory(category);
            model.addAttribute("category", category.getTranslation());
        } else {
            products = productRepository.findAll();
            model.addAttribute("category", "wszystkie");
        }
        model.addAttribute("products", products);

        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        model.addAttribute("priceSum", sum);

        return "list";
    }

    @PostMapping("/dodaj")
    public String add(@RequestParam String name, @RequestParam double price, @RequestParam ProductCategory category) {
        Product product = new Product(name, price, category);
        if (name.equals("") || (price <= 0)) {
            return "redirect:/err.html";
        } else {
            productRepository.add(product);
            return "redirect:/lista";
        }
    }
}
