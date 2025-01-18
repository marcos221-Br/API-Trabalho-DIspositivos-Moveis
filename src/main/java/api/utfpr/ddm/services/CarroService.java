package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.repositories.CarroImagemRepository;
import api.utfpr.ddm.repositories.CarroRepository;
import api.utfpr.ddm.repositories.CaracteristicaRepository;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroImagemRepository carroImageRepository;

    @Autowired
    private CaracteristicaRepository featureRepository;

    public Carro createCarro(Carro carro){
        return this.carroRepository.save(carro);
    }

    public List<Carro> getAllCarros(){
        return this.carroRepository.findAll();
    }

    public Carro getCarro(Integer id){
        return this.carroRepository.getReferenceById(id);
    }

    public List<Carro> getCarroByUser(Integer user){
        return this.carroRepository.findByUser(user);
    }

    public Carro updateCarro(Integer id, Carro carro){
        carro.setId(id);
        return this.carroRepository.save(carro);
    }

    public void deleteCarro(Integer id){
        this.carroImageRepository.deleteByCar(id);
        this.featureRepository.deleteByCar(id);
        this.carroRepository.deleteById(id);
    }
}
