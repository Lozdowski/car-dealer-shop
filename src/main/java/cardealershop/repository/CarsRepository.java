package cardealershop.repository;

import cardealershop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car,Long> {

    @Query("select c from Car c where c.id=?1")
    Car getCarById(long id);
}
