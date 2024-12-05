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

import api.utfpr.ddm.dtos.CarImageDto;
import api.utfpr.ddm.dtos.CarImageResponseDto;
import api.utfpr.ddm.models.CarImage;
import api.utfpr.ddm.services.CarImageService;

@RestController
@RequestMapping("/api/carimage")
public class CarImageController {
    
    @Autowired
    private CarImageService carImageService;

    @PostMapping
    public List<CarImageResponseDto> createCarImage(@RequestBody CarImageDto carImageDto){
        List<CarImageResponseDto> carImageResponseDtos = new ArrayList<>();
        for (CarImage carImage : carImageDto.carImageObject()) {
            carImageResponseDtos.add(CarImageResponseDto.carImageDto(this.carImageService.createCarImage(carImage)));
        }
        return carImageResponseDtos;
    }

    @GetMapping("/{car}")
    public List<CarImageResponseDto> getCarImages(@PathVariable Integer car){
        List<CarImageResponseDto> carImageResponseDtos = new ArrayList<>();
        List<CarImage> carImages = this.carImageService.getImages(car);
        for (CarImage carImage : carImages) {
            carImageResponseDtos.add(CarImageResponseDto.carImageDto(carImage));
        }
        return carImageResponseDtos;
    }

    @PutMapping("/{id}")
    public CarImageResponseDto updateCarImage(@PathVariable Integer id, @RequestBody CarImageDto carImageDto){
        return CarImageResponseDto.carImageDto(this.carImageService.updateCarImage(id, carImageDto.carImageObject().getFirst()));
    }

    @DeleteMapping("/{id}")
    public void deleteCarImage(@PathVariable Integer id){
        this.carImageService.deleteCarImage(id);
    }
}
