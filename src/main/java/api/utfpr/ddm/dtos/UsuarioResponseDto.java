package api.utfpr.ddm.dtos;

import java.sql.Date;

import api.utfpr.ddm.models.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioResponseDto {
    
    private Integer id;
    private String nome; // name
    private String email;
    private Date dataNascimento; // bornDate
    private String telefone; // ccellphone

    public static UsuarioResponseDto userDto(Usuario usuario){
        return new UsuarioResponseDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento(), usuario.getTelefone());
    }
}
