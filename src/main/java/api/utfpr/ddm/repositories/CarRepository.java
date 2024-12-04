package api.utfpr.ddm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.ddm.models.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {
    
}
