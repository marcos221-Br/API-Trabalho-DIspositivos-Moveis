package api.utfpr.ddm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    @Query(value = "SELECT * FROM users WHERE email=?", nativeQuery = true)
    public User findByEmail(String email);
}
