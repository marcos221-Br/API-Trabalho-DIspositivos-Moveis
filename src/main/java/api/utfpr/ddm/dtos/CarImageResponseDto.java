package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.CarImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CarImageResponseDto {

    private Integer id;
    private CarResponseDto carro;
    private ImageResponseDto imagem;

    public static CarImageResponseDto carImageDto(CarImage carImage){
        return new CarImageResponseDto(CarResponseDto.carDto(carImage.getCar()), ImageResponseDto.imageDto(carImage.getImage()));
    }
}
