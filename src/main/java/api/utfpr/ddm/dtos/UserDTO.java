package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDTO {
    
    private String name;
    private long cellphone;
    private String email;
    private String password;

    public User userObject(){
        return new User(name, cellphone, email, password);
    }
}
