package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.UserDTO;
import api.utfpr.ddm.dtos.UserResponseDTO;
import api.utfpr.ddm.models.User;
import api.utfpr.ddm.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserDTO userDTO){
        return UserResponseDTO.userDTO(this.userService.createUser(userDTO.userObject()));
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        for (User user : users) {
            userResponseDTOs.add(UserResponseDTO.userDTO(user));
        }
        return userResponseDTOs;
    }

    @GetMapping("/{email}")
    public UserResponseDTO getUser(@PathVariable String email){
        return UserResponseDTO.userDTO(this.userService.getUser(email));
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        return UserResponseDTO.userDTO(this.userService.updateUser(id,userDTO.userObject()));
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        this.userService.deleteUser(user);
    }
}
