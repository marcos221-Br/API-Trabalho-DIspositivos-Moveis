package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.exceptions.DuplicateEntryException;
import api.utfpr.ddm.models.User;
import api.utfpr.ddm.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        try{
            return this.userRepository.save(user);
        }catch(DataIntegrityViolationException e){
            throw new DuplicateEntryException("Email já cadastrado!");
        }
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return this.userRepository.findByEmail(email).get();
    }

    public User updateUser(Integer id, User user){
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
