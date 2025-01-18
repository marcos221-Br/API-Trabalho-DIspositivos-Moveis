package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.Carro;
import api.utfpr.ddm.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CarroDto {
    
    private String marca; // Brand
    private String modelo; // Model
    private Integer ano; // Year
    private Double preco; // Price
    private Integer quilometragem; // Mileage
    private String tipoCombustivel; // Fuel
    private String transmissao; // Transmission
    private String cor; // Color
    private Integer potencia; // Power
    private String status;
    private String descricao; // Description
    private Date dataCriacao; // Created
    private Date dataAtualizacao; // Updated
    private Usuario usuario; // User

    public Carro carroObjeto(){
        return new Carro(marca, modelo, ano, preco, quilometragem, tipoCombustivel, transmissao, cor, potencia, status, descricao, Date.valueOf(dataCriacao.toLocalDate().plusDays(1)), Date.valueOf(dataAtualizacao.toLocalDate().plusDays(1)), usuario);
    }
}
