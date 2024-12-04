package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.CarImage;
import api.utfpr.ddm.repositories.CarImageRepository;

@Service
public class CarImageService {

    @Autowired
    private CarImageRepository carImageRepository;

    public CarImage createCarImage(CarImage carImage){
        return this.carImageRepository.save(carImage);
    }

    public List<CarImage> getAllCarImages(){
        return this.carImageRepository.findAll();
    }

    public List<CarImage> getImages(Integer car){
        return this.carImageRepository.findByCar(car);
    }

    public CarImage updateCarImage(Integer id, CarImage carImage){
        carImage.setId(id);
        return this.carImageRepository.save(carImage);
    }

    public void deleteCarImage(Integer id){
        this.carImageRepository.deleteById(id);
    }
}
