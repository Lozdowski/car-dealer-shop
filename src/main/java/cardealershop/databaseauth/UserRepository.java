package cardealershop.databaseauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserApp,Long> {

    @Query("select u from UserApp u where u.login =?1")
    Optional<UserApp> findUserAppByLogin(String login);

}
