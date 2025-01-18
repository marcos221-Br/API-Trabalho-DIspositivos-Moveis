package api.utfpr.ddm.dtos;

import java.util.ArrayList;
import java.util.List;

import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.models.CarroImagem;
import api.utfpr.ddm.models.Imagem;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CarroImagemDto {
    
    private Carro carro;
    private List<Imagem> imagens;

    public List<CarroImagem> carroImagemObject(){
        List<CarroImagem> carroImagems = new ArrayList<>();
        for(Imagem imagem : imagens){
            carroImagems.add(new CarroImagem(carro, imagem));
        }
        return carroImagems;
    }
}
