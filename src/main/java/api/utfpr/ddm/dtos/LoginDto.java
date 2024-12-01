package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LoginDto {
    
    private String email;
    private String senha;

    public User userObject(){
        return new User(email, senha);
    }
}
