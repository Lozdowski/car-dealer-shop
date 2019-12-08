package cardealershop.controller;

import cardealershop.model.Car;
import cardealershop.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private CarsService carsService;

    public ViewController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/admin/cars")
    public String getHomePage(Model model, @RequestParam(value = "message" ,required = false) String resultMessage){
        String welcome = "Add car to a list of cars: ";
        model.addAttribute("welcome", welcome);
        model.addAttribute("resultMessage",resultMessage);
        model.addAttribute("cars",carsService.getCars());
        return "home";
    }
    @PostMapping("/admin/cars/add")
    public String addCar(@ModelAttribute Car inCar, Model model){
        Car car = new Car();
        car.setBrand(inCar.getBrand());
        car.setModel(inCar.getModel());
        car.setProdYear(inCar.getProdYear());
        model.addAttribute("car",car);
        carsService.createCar(car);
        return "redirect:/cars";
    }
    @GetMapping("admin/cars/delete")
    public String deleteCar(@RequestParam long id){
        carsService.deleteCarById(id);
        return "redirect:/cars";

    }
    @GetMapping("/admin/cars/update")
    public String updateCar(@RequestParam  long id, Model model){
        Car car = carsService.getCar(id);
        if(car==null) return "cannot find car to update !";
        model.addAttribute("car",car);
        System.out.println(car);
        return "update";
        //    return carService.updateCar(car);
    }
    @PostMapping("/admin/cars/update/confirm")
    public String updateCarConfirm(@ModelAttribute Car inCar) {
        Car car = new Car();
        car.setId(inCar.getId());
        car.setBrand(inCar.getBrand());
        car.setModel(inCar.getModel());
        car.setProdYear(inCar.getProdYear());
        carsService.createCar(car);
        return "redirect:/cars?message=" + car;
    }


}