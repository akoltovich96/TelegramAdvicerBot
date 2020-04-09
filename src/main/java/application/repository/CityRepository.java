package application.repository;

import application.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    void deleteByName(String name);

    City findByName(String name);

    @Override
    List<City> findAll();
}
