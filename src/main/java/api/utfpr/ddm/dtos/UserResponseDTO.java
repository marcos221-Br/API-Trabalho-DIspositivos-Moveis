package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDTO {
    
    private Integer id;
    private String name;
    private long cellphone;
    private String email;

    public static UserResponseDTO userDTO(User user){
        return new UserResponseDTO(user.getId(),user.getName(),user.getCellphone(),user.getEmail());
    }
}
