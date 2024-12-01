package api.utfpr.ddm.dtos;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.utfpr.ddm.models.Address;
import api.utfpr.ddm.models.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDto {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private String nome; // name
    private String email;
    private String senha; // password
    private Date dataNascimento; // bornDate
    private Address endereco; // address
    private String telefone; // cellphone

    public UserDto(String nome, String email, String senha, Date dataNascimento, Address endereco, String telefone) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public User userObject(){
        return new User(nome, email, this.passwordEncoder.encode(senha), Date.valueOf(dataNascimento.toLocalDate().plusDays(1)), telefone, endereco);
    }
}
