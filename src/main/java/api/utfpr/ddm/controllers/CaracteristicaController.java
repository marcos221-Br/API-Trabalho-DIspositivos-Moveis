package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.CaracteristicaDto;
import api.utfpr.ddm.dtos.CaracteristicaResponseDto;
import api.utfpr.ddm.models.Caracteristica;
import api.utfpr.ddm.services.CaracteristicaService;

@RestController
@RequestMapping("/api/feature")
public class CaracteristicaController {
    
    @Autowired
    private CaracteristicaService caracteristicaService;

    @PostMapping
    public List<CaracteristicaResponseDto> createCaracteristica(@RequestBody CaracteristicaDto caracteristicaDto){
        List<CaracteristicaResponseDto> caracteristicaResponseDtos = new ArrayList<>();
        for(Caracteristica caracteristica : caracteristicaDto.caracteristicaObject()){
            caracteristicaResponseDtos.add(CaracteristicaResponseDto.caracteristicaDto(this.caracteristicaService.createCaracteristica(caracteristica)));
        }
        return caracteristicaResponseDtos;
    }

    @GetMapping("/{car}")
    public List<CaracteristicaResponseDto> getCaracteristicas(@PathVariable Integer car){
        List<CaracteristicaResponseDto> caracteristicaResponseDtos = new ArrayList<>();
        List<Caracteristica> caracteristicas = this.caracteristicaService.getCaracteristicas(car);
        for(Caracteristica caracteristica : caracteristicas){
            caracteristicaResponseDtos.add(CaracteristicaResponseDto.caracteristicaDto(caracteristica));
        }
        return caracteristicaResponseDtos;
    }

    @PutMapping("/{id}")
    public CaracteristicaResponseDto updateCaracteristica(@PathVariable Integer id, @RequestBody CaracteristicaDto caracteristicaDto){
        return CaracteristicaResponseDto.caracteristicaDto(this.caracteristicaService.updateCaracteristica(id, caracteristicaDto.caracteristicaObject().getFirst()));
    }

    @DeleteMapping("/{id}")
    public void deletCcaracteristica(@PathVariable Integer id){
        this.caracteristicaService.deleteCaracteristica(id);
    }
}
