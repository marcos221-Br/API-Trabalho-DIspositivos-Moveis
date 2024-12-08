package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {
    
    @Query(value = "SELECT * FROM cars WHERE user?", nativeQuery = true)
    public List<Car> findByUser(Integer user);
}
