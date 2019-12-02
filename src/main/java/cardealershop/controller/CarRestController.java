package cardealershop.controller;

import cardealershop.model.Car;
import cardealershop.service.CarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarRestController {

    private CarsService carsService;

    public CarRestController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/api/cars")
    public List<Car> getCars(){
        return carsService.getCars();
    }
    @GetMapping("api/cars/{id}")
    public Car getCar(@PathVariable long id){
        return carsService.getCarById(id);
    }
    @PutMapping("/api/cars/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car){
        return carsService.updateCar(id,car);
    }
    @PostMapping("/api/cars/add")
    public Car createCar(@RequestBody Car car){
        return carsService.createCar(car);
    }
    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id){
        return carsService.deleteCarById(id);
    }
}
