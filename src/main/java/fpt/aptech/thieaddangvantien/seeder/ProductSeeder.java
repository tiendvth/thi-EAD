package fpt.aptech.thieaddangvantien.seeder;

import com.github.javafaker.Faker;
import fpt.aptech.thieaddangvantien.entity.Product;
import fpt.aptech.thieaddangvantien.repository.ProductRepository;
import fpt.aptech.thieaddangvantien.util.NumberHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductSeeder {
    private static final int NUMBER_PRODUCTS = 100;
    public static List<Product> productList = new ArrayList<>();
    final ProductRepository productRepository;

    public void generate() {
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_PRODUCTS; i++
        ) {
            Product product = Product.builder()
                    .name(faker.name().title())
                    .dateOfManf(LocalDateTime.now().minusDays(NumberHelper.generateRandom(1, 30)))
                    .description(faker.weather().description())
                    .price(NumberHelper.generateRandom(10000, 100000))
                    .build();
            productList.add(product);
        }
        productRepository.saveAll(productList);
    }
}