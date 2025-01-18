package api.utfpr.ddm.dtos;

import java.util.ArrayList;
import java.util.List;

import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.models.Caracteristica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CaracteristicaDto {
    
    private Carro carro;
    private List<String> caracteristicas;

    public List<Caracteristica> caracteristicaObject(){
        List<Caracteristica> Caracteristicas = new ArrayList<>();
        for(String Caracteristica : caracteristicas){
            Caracteristicas.add(new Caracteristica(carro, Caracteristica));
        }
        return Caracteristicas;
    }
}
