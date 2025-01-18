package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LoginResponseDto {
    
    private String token;
    private long expiresIn;
    private UsuarioResponseDto usuario;

    public static LoginResponseDto loginDto(String token, long expirationTime, Usuario usuario){
        return new LoginResponseDto(token, expirationTime, UsuarioResponseDto.userDto(usuario));
    }
}
