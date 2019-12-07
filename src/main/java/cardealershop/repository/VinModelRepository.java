package cardealershop.repository;

import cardealershop.model.VinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinModelRepository extends JpaRepository<VinModel, Long> {

}
