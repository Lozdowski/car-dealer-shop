package cardealershop.controller;

import cardealershop.model.Car;
import cardealershop.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForUserCarController {

    private CarsService carsService;

    public ForUserCarController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/cars")
    public String listOfAllCars(ModelMap modelMap){
        modelMap.put("listcars",carsService.getCars());
        return "cars";
    }
    @GetMapping("/cars/{id}")
    public String carAllData(@PathVariable long id, ModelMap modelMap){
        Car car = carsService.getCarById(id);
        modelMap.put("car",car);
        return "carById";
    }
}
