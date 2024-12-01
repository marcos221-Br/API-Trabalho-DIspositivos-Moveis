package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AddressResponseDto {

    private Integer id;
    private String cep;
    private String logradouro; // road
    private String bairro; // neighborhood
    private String uf; // state
    private String localidade; // country
    private String complemento; // complement

    public static AddressResponseDto addressDto(Address address){
        try{
            return new AddressResponseDto(address.getId(), address.getCep(), address.getRoad(), address.getNeighborhood(), address.getState(), address.getCountry(), address.getComplement());
        }catch(NullPointerException e){
            return null;
        }
    }
}
