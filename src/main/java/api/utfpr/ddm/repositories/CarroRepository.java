package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.Carro;

public interface CarroRepository extends JpaRepository<Carro,Integer> {
    
    @Query(value = "SELECT * FROM carros WHERE usuario=?", nativeQuery = true)
    public List<Carro> findByUser(Integer usuario);
}
