package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.CarroImagem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CarroImagemResponseDto {

    private Integer id;
    private CarResponseDto carro;
    private ImageResponseDto imagem;

    public static CarroImagemResponseDto carroImagemDto(CarroImagem carImage){
        return new CarroImagemResponseDto(carImage.getId(), CarResponseDto.carDto(carImage.getCarro()), ImageResponseDto.imageDto(carImage.getImagem()));
    }
}
