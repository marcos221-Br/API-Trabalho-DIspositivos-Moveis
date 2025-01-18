package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.Carro;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CarResponseDto {
    
    private Integer id;
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
    private UsuarioResponseDto usuario; // User

    public static CarResponseDto carDto(Carro car){
        return new CarResponseDto(car.getId(),car.getMarca(),car.getModelo(),car.getAno(),car.getPreco(),car.getQuilometragem(),car.getCombustivel(),car.getTransmissao(),car.getCor(),car.getForca(),car.getStatus(),car.getDescricao(),car.getDataCriacao(),car.getDataAtualizacao(),UsuarioResponseDto.userDto(car.getUsuario()));
    }
}
