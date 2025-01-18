package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.exceptions.DuplicateEntryException;
import api.utfpr.ddm.models.Usuario;
import api.utfpr.ddm.repositories.UserRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UserRepository userRepository;

    public Usuario createUser(Usuario usuario){
        try{
            return this.userRepository.save(usuario);
        }catch(DataIntegrityViolationException e){
            throw new DuplicateEntryException("Email já cadastrado!");
        }
    }

    public List<Usuario> getAllUsers(){
        return this.userRepository.findAll();
    }

    public Usuario getUserByEmail(String email){
        return this.userRepository.findByEmail(email).get();
    }

    public Usuario updateUser(Integer id, Usuario user){
        user.setId(id);
        try{
            return this.userRepository.save(user);
        }catch(DataIntegrityViolationException e){
            throw new DuplicateEntryException("Email já cadastrado por outro usuário!");
        }
    }

    public void deleteUser(Integer id){
        this.userRepository.deleteById(id);
    }
}
