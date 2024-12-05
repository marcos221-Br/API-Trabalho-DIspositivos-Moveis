package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.Car;
import api.utfpr.ddm.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CarDto {
    
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
    private User usuario; // User

    public Car carObject(){
        return new Car(marca, modelo, ano, preco, quilometragem, tipoCombustivel, transmissao, cor, potencia, status, descricao, Date.valueOf(dataCriacao.toLocalDate().plusDays(1)), Date.valueOf(dataAtualizacao.toLocalDate().plusDays(1)), usuario);
    }
}
