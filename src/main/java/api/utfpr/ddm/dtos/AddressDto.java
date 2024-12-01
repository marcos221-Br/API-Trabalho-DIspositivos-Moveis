package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class AddressDto {
    
    private String cep;
    private String logradouro; // road
    private String bairro; // neighborhood
    private String uf; // state
    private String localidade; // country
    private String complemento; // complement

    public Address addressObject(){
        return new Address(cep,logradouro,bairro,uf,localidade,complemento);
    }
}
