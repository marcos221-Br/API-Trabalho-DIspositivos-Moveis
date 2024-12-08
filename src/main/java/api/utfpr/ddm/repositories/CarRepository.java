package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.ddm.models.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {
    
    public List<Car> findByUser_Id(Integer user);
}
