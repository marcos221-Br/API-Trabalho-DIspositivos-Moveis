package api.utfpr.ddm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.LoginDto;
import api.utfpr.ddm.dtos.LoginResponseDto;
import api.utfpr.ddm.dtos.UsuarioDto;
import api.utfpr.ddm.models.Usuario;
import api.utfpr.ddm.services.AuthenticationService;
import api.utfpr.ddm.services.JwtService;
import api.utfpr.ddm.services.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UsuarioService userService;

    @PostMapping("/signup")
    public LoginResponseDto singUp(@RequestBody UsuarioDto userDto){
        if(this.userService.createUser(userDto.usuarioObeto()) != null){
            LoginDto loginDto = new LoginDto(userDto.getEmail(), userDto.getSenha());
            Usuario authenticatedUser = authenticationService.authenticate(loginDto.userObject());
            return LoginResponseDto.loginDto(jwtService.generateToken(authenticatedUser),jwtService.getExpirationTime(),authenticatedUser);
        }else{
            return null;
        }
    }

    @PostMapping("/login")
    public LoginResponseDto authenticate(@RequestBody LoginDto loginDto) {
        Usuario authenticatedUser = authenticationService.authenticate(loginDto.userObject());
        return LoginResponseDto.loginDto(jwtService.generateToken(authenticatedUser),jwtService.getExpirationTime(),authenticatedUser);
    }
}
