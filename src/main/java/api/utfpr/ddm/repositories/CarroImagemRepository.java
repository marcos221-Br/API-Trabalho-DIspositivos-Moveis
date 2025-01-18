package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.CarroImagem;
import jakarta.transaction.Transactional;

public interface CarroImagemRepository extends JpaRepository<CarroImagem,Integer> {
    
    @Query(value = "SELECT * FROM carroimagens WHERE carro=?", nativeQuery = true)
    public List<CarroImagem> findByCar(Integer carro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM carroimagens WHERE carro=?", nativeQuery = true)
    public void deleteByCar(Integer carro);
}
