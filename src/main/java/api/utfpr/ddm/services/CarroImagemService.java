package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.CarroImagem;
import api.utfpr.ddm.repositories.CarroImagemRepository;

@Service
public class CarroImagemService {

    @Autowired
    private CarroImagemRepository carroImagemRepository;

    public CarroImagem createCarroImagem(CarroImagem carroImagem){
        return this.carroImagemRepository.save(carroImagem);
    }

    public List<CarroImagem> getAllCarroImagems(){
        return this.carroImagemRepository.findAll();
    }

    public List<CarroImagem> getImages(Integer car){
        return this.carroImagemRepository.findByCar(car);
    }

    public CarroImagem updateCarroImagem(Integer id, CarroImagem carroImagem){
        carroImagem.setId(id);
        return this.carroImagemRepository.save(carroImagem);
    }

    public void deleteCarroImagem(Integer id){
        this.carroImagemRepository.deleteById(id);
    }
}
