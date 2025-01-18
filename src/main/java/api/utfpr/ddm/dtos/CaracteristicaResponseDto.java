package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Caracteristica;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CaracteristicaResponseDto {
    
    private Integer id;
    private CarResponseDto carro;
    private String caracteristica;

    public static CaracteristicaResponseDto caracteristicaDto(Caracteristica caracteristica){
        return new CaracteristicaResponseDto(caracteristica.getId(), CarResponseDto.carDto(caracteristica.getCarro()), caracteristica.getCaracteristica());
    }
}
