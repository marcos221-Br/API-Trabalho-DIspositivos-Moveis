package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.Caracteristica;
import jakarta.transaction.Transactional;

public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer> {
    
    @Query(value = "SELECT * FROM caracteristicas WHERE carro=?", nativeQuery = true)
    public List<Caracteristica> findByCar(Integer carro);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM caracteristicas WHERE carro=?", nativeQuery = true)
    public void deleteByCar(Integer carro);
}
