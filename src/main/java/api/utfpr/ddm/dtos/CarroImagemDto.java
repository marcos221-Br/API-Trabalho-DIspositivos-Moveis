package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.models.CarroImagem;
import api.utfpr.ddm.models.Imagem;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CarroImagemDto {
    
    private Carro carro;
    private Imagem imagem;

    public CarroImagem carroImagemObject(){
        return new CarroImagem(carro, imagem);
    }
}
