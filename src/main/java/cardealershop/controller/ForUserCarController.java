package cardealershop.controller;

import cardealershop.model.Car;
import cardealershop.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ForUserCarController {

    private CarsService carsService;

    public ForUserCarController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/cars")
    public String listOfAllCars(Model model){
        model.addAttribute("listcars",carsService.getCars());

        return "cars";
    }
    @GetMapping("/cars/{id}")
    public String carAllData(@PathVariable long id, ModelMap modelMap){
        Car car = carsService.getCarById(id);
        modelMap.put("car",car);
        return "carById";
    }
}
