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

import api.utfpr.ddm.dtos.CarroImagemDto;
import api.utfpr.ddm.dtos.CarroImagemResponseDto;
import api.utfpr.ddm.models.CarroImagem;
import api.utfpr.ddm.services.CarroImagemService;

@RestController
@RequestMapping("/api/carimage")
public class CarroImagemController {
    
    @Autowired
    private CarroImagemService carroImagemService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CarroImagemResponseDto createCarroImagem(@RequestBody CarroImagemDto carroImagemDto){
        return CarroImagemResponseDto.carroImagemDto(this.carroImagemService.createCarroImagem(carroImagemDto.carroImagemObject()));
    }

    @GetMapping("/{car}")
    public List<CarroImagemResponseDto> getCarroImagems(@PathVariable Integer car){
        List<CarroImagemResponseDto> carroImagemResponseDtos = new ArrayList<>();
        List<CarroImagem> carroImagems = this.carroImagemService.getImages(car);
        for (CarroImagem carroImagem : carroImagems) {
            carroImagemResponseDtos.add(CarroImagemResponseDto.carroImagemDto(carroImagem));
        }
        return carroImagemResponseDtos;
    }

    @PutMapping("/{id}")
    public CarroImagemResponseDto updateCarroImagem(@PathVariable Integer id, @RequestBody CarroImagemDto carroImagemDto){
        return CarroImagemResponseDto.carroImagemDto(this.carroImagemService.updateCarroImagem(id, carroImagemDto.carroImagemObject()));
    }

    @DeleteMapping("/{id}")
    public void deleteCarroImagem(@PathVariable Integer id){
        this.carroImagemService.deleteCarroImagem(id);
    }
}
