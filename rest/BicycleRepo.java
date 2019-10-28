package spring_boot.spring_boot.rest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepo extends CrudRepository<Bicycle,Long>
{
    @Query("SELECT '*' FROM Bicycle u where u.name = :name and u.mark = :mark")
    List<Bicycle> findByNameAndMark(@Param("name") String name, @Param("mark") String mark);
}
