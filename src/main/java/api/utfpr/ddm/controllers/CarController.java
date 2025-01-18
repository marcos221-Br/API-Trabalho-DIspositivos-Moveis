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

import api.utfpr.ddm.dtos.CarResponseDto;
import api.utfpr.ddm.dtos.CarroDto;
import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.services.CarroService;

@RestController
@RequestMapping("/api/car")
public class CarController {
    
    @Autowired
    private CarroService carService;

    @PostMapping
    public CarResponseDto createCar(@RequestBody CarroDto carDto){
        return CarResponseDto.carDto(this.carService.createCarro(carDto.carroObjeto()));
    }

    @GetMapping
    public List<CarResponseDto> getAllCars(){
        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        List<Carro> cars = this.carService.getAllCarros();
        for(Carro car : cars){
            carResponseDtos.add(CarResponseDto.carDto(car));
        }
        return carResponseDtos;
    }

    @GetMapping("/{id}")
    public CarResponseDto getCar(@PathVariable Integer id){
        return CarResponseDto.carDto(this.carService.getCarro(id));
    }

    @GetMapping("/user/{user}")
    public List<CarResponseDto> getCarByUser(@PathVariable Integer user){
        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        List<Carro> cars = this.carService.getCarroByUser(user);
        for(Carro car : cars){
            carResponseDtos.add(CarResponseDto.carDto(car));
        }
        return carResponseDtos;
    }

    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable Integer id, @RequestBody CarroDto carDto){
        return CarResponseDto.carDto(this.carService.updateCarro(id, carDto.carroObjeto()));
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id){
        this.carService.deleteCarro(id);
    }
}
