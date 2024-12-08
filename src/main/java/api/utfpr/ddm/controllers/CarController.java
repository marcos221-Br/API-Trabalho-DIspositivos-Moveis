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

import api.utfpr.ddm.dtos.CarDto;
import api.utfpr.ddm.dtos.CarResponseDto;
import api.utfpr.ddm.models.Car;
import api.utfpr.ddm.services.CarService;

@RestController
@RequestMapping("/api/car")
public class CarController {
    
    @Autowired
    private CarService carService;

    @PostMapping
    public CarResponseDto createCar(@RequestBody CarDto carDto){
        return CarResponseDto.carDto(this.carService.createCar(carDto.carObject()));
    }

    @GetMapping
    public List<CarResponseDto> getAllCars(){
        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        List<Car> cars = this.carService.getAllCars();
        for(Car car : cars){
            carResponseDtos.add(CarResponseDto.carDto(car));
        }
        return carResponseDtos;
    }

    @GetMapping("/{id}")
    public CarResponseDto getCar(@PathVariable Integer id){
        return CarResponseDto.carDto(this.carService.getCar(id));
    }

    @GetMapping("/user/{user}")
    public List<CarResponseDto> getCarByUser(@PathVariable Integer user){
        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        List<Car> cars = this.carService.getCarByUser(user);
        for(Car car : cars){
            carResponseDtos.add(CarResponseDto.carDto(car));
        }
        return carResponseDtos;
    }

    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable Integer id, @RequestBody CarDto carDto){
        return CarResponseDto.carDto(this.carService.updateCar(id, carDto.carObject()));
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id){
        this.carService.deleteCar(id);
    }
}
