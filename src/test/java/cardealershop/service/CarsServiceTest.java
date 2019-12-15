package cardealershop.service;

import cardealershop.model.Car;
import cardealershop.repository.CarsRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CarsServiceTest {

    @InjectMocks
    private CarsService carsService;
    @Mock
    private CarsRepository carsRepository;
    @Test
    public void testGetCar() {
        Car car1 = new Car("Mercedes", "C", "40000", "190000", "2007", "mercedes");
        Car car2 = new Car("Audi", "A4", "35500", "280000", "2011", "AUDIA4");

        when(carsService.getCar(1)).thenReturn(car1);
        assertEquals(car1, carsService.getCar(1));

    }
    @Test
    public void testGetCars(){
        Car car1 = new Car("Mercedes", "C", "40000", "190000", "2007", "mercedes");
        Car car2 = new Car("Audi", "A4", "35500", "280000", "2011", "AUDIA4");
        when(carsService.getCars()).thenReturn(Arrays.asList(car1,car2));
        assertEquals(2,carsService.getCars().size());
    }

    }