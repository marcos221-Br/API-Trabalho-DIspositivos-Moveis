package api.utfpr.ddm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.ddm.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
    
    public Optional<Usuario> findByEmail(String email);
}
