package api.utfpr.ddm.dtos;

import java.util.ArrayList;
import java.util.List;

import api.utfpr.ddm.models.Car;
import api.utfpr.ddm.models.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class FeatureDto {
    
    private Car carro;
    private List<String> caracteristicas;

    public List<Feature> featureObject(){
        List<Feature> features = new ArrayList<>();
        for(String feature : caracteristicas){
            features.add(new Feature(carro, feature));
        }
        return features;
    }
}
