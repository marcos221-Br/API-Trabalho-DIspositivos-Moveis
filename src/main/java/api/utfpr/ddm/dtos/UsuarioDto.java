package api.utfpr.ddm.dtos;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.utfpr.ddm.models.Usuario;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UsuarioDto {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private String nome; // name
    private String email;
    private String senha; // password
    private Date dataNascimento; // bornDate
    private String telefone; // cellphone

    public UsuarioDto(String nome, String email, String senha, Date dataNascimento, String telefone) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Usuario usuarioObeto(){
        return new Usuario(nome, email, this.passwordEncoder.encode(senha), Date.valueOf(dataNascimento.toLocalDate().plusDays(1)), telefone);
    }
}
