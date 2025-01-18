package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.Caracteristica;
import api.utfpr.ddm.repositories.CaracteristicaRepository;

@Service
public class CaracteristicaService {
    
    @Autowired
    private CaracteristicaRepository CaracteristicaRepository;

    public Caracteristica createCaracteristica(Caracteristica Caracteristica){
        return this.CaracteristicaRepository.save(Caracteristica);
    }

    public List<Caracteristica> getAllCaracteristicas(){
        return this.CaracteristicaRepository.findAll();
    }

    public List<Caracteristica> getCaracteristicas(Integer car){
        return this.CaracteristicaRepository.findByCar(car);
    }

    public Caracteristica updateCaracteristica(Integer id, Caracteristica Caracteristica){
        Caracteristica.setId(id);
        return this.CaracteristicaRepository.save(Caracteristica);
    }

    public void deleteCaracteristica(Integer id){
        this.CaracteristicaRepository.deleteById(id);
    }
}
