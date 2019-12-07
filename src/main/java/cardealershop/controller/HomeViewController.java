package cardealershop.controller;

import cardealershop.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    private CarsService carsService;

    public HomeViewController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/")
    public String getHome(){
       return "index";
    }
}
