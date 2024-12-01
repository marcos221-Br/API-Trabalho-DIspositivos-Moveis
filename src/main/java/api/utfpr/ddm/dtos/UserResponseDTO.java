package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDto {
    
    private Integer id;
    private String nome; // name
    private String email;
    private Date dataNascimento; // bornDate
    private String telefone; // ccellphone
    private AddressResponseDto endereco; // address

    public static UserResponseDto userDto(User user){
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getBornDate(), user.getCellphone(), AddressResponseDto.addressDto(user.getAddress()));
    }
}
