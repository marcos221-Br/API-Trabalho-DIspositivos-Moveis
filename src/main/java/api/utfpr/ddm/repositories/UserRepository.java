package api.utfpr.ddm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
    public Optional<User> findByEmail(String email);

    @Query(value = "DELETE FROM users WHERE address=?", nativeQuery = true)
    public void deleteByAddress(Integer address);
}
