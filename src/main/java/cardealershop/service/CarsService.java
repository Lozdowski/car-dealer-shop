package cardealershop.service;

import cardealershop.exception.ResourceNotFoundException;
import cardealershop.model.Car;
import cardealershop.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    @Autowired
    private CarsRepository carsRepository;

    public CarsService() {
    }

    public Car createCar(Car car) {
        return carsRepository.save(car);
    }

    public List<Car> getCars() {
        return carsRepository.findAll();
    }
    public Car getCarById(long id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("car by id: " + id + " not found"));
    }
    public Car updateCar(long id, Car car) {
        return carsRepository.findById(id).map(c->{
            c.setBrand(car.getBrand());
            c.setProdYear(car.getProdYear());
            c.setModel(car.getModel());
            c.setMileage(car.getMileage());
            c.setPrice(car.getPrice());
            c.setImageUrl(car.getImageUrl());
            return carsRepository.save(c);
        }).orElseThrow(()->new ResourceNotFoundException("car with id: "+ id+ " not found"));
    }
    public Car getCar(long id){
        return carsRepository.getCarById(id);
    }

    public ResponseEntity<?> deleteCarById(long id) {
        return carsRepository.findById(id).map(c->{
            carsRepository.deleteById(id);
            return new ResponseEntity<>("car by id "+id+" was deleted", HttpStatus.OK);
        }).orElseThrow(()-> new ResourceNotFoundException("car by id: "+id+" not found"));
    }

}
