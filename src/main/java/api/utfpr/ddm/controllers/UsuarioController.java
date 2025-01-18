package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.UsuarioDto;
import api.utfpr.ddm.dtos.UsuarioResponseDto;
import api.utfpr.ddm.models.Usuario;
import api.utfpr.ddm.services.UsuarioService;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDto> getAllUsers(){
        List<Usuario> users = this.usuarioService.getAllUsers();
        List<UsuarioResponseDto> userResponseDtos = new ArrayList<>();
        for(Usuario user : users){
            userResponseDtos.add(UsuarioResponseDto.userDto(user));
        }
        return userResponseDtos;
    }

    @GetMapping("/{email}")
    public UsuarioResponseDto getUser(@PathVariable String email){
        return UsuarioResponseDto.userDto(this.usuarioService.getUserByEmail(email));
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto updateUser(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto){
        return UsuarioResponseDto.userDto(this.usuarioService.updateUser(id, usuarioDto.usuarioObeto()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.usuarioService.deleteUser(id);
    }
}
