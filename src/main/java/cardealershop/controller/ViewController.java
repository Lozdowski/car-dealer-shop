package cardealershop.controller;

import cardealershop.databaseauth.UserRepository;
import cardealershop.model.Car;
import cardealershop.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private CarsService carsService;

    public ViewController(CarsService carsService) {
        this.carsService = carsService;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/cars")
    public String getHomePage(Model model, @RequestParam(value = "message" ,required = false) String resultMessage){
        String welcome = "Add car to a list of cars: ";
        model.addAttribute("welcome", welcome);
        model.addAttribute("resultMessage",resultMessage);
        model.addAttribute("cars",carsService.getCars());
        return "home";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin/cars/delete")
    public String deleteCar(@RequestParam long id){
        carsService.deleteCarById(id);
        return "redirect:/cars";

    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/cars/update")
    public String updateCar(@RequestParam  long id, Model model){
        Car car = carsService.getCar(id);
        if(car==null) return "cannot find car to update !";
        model.addAttribute("car",car);
        System.out.println(car);
        return "update";
        //    return carService.updateCar(car);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
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