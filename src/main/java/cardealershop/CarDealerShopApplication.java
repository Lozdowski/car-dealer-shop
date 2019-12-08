package cardealershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties

public class CarDealerShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarDealerShopApplication.class, args);
    }

}
