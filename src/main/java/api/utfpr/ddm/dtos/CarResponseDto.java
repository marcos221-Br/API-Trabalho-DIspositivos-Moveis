package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.Car;
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
    private UserResponseDto usuario; // User

    public static CarResponseDto carDto(Car car){
        return new CarResponseDto(car.getId(),car.getBrand(),car.getModel(),car.getYear(),car.getPrice(),car.getMileage(),car.getFuel(),car.getTransmission(),car.getColor(),car.getPower(),car.getStatus(),car.getDescription(),car.getCreated(),car.getUpdated(),UserResponseDto.userDto(car.getUser()));
    }
}
