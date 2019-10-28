package spring_boot.spring_boot.Resttemplate.Example_2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends CrudRepository<ApplicationUser,Long>
{
    Optional<ApplicationUser> findByLogin(String login);
}
