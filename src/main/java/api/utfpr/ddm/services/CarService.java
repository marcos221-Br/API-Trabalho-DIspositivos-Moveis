package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.Car;
import api.utfpr.ddm.repositories.CarImageRepository;
import api.utfpr.ddm.repositories.CarRepository;
import api.utfpr.ddm.repositories.FeatureRepository;

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarImageRepository carImageRepository;

    @Autowired
    private FeatureRepository featureRepository;

    public Car createCar(Car car){
        return this.carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return this.carRepository.findAll();
    }

    public Car getCar(Integer id){
        return this.carRepository.getReferenceById(id);
    }

    public List<Car> getCarByUser(Integer user){
        return this.carRepository.findByUser(user);
    }

    public Car updateCar(Integer id, Car car){
        car.setId(id);
        return this.carRepository.save(car);
    }

    public void deleteCar(Integer id){
        this.carImageRepository.deleteByCar(id);
        this.featureRepository.deleteByCar(id);
        this.carRepository.deleteById(id);
    }
}
