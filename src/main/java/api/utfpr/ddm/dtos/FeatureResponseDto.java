package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Feature;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FeatureResponseDto {
    
    private Integer id;
    private CarResponseDto carro;
    private String caracteristica;

    public static FeatureResponseDto featureDto(Feature feature){
        return new FeatureResponseDto(feature.getId(), CarResponseDto.carDto(feature.getCar()), feature.getFeature());
    }
}
