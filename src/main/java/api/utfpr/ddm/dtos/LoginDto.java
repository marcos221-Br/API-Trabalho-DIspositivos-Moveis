package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LoginDto {
    
    private String email;
    private String senha;

    public Usuario userObject(){
        return new Usuario(email, senha);
    }
}
