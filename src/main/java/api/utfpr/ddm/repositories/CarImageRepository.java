package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.CarImage;
import jakarta.transaction.Transactional;

public interface CarImageRepository extends JpaRepository<CarImage,Integer> {
    
    @Query(value = "SELECT * FROM carimages WHERE car=?", nativeQuery = true)
    public List<CarImage> findByCar(Integer car);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM carimages WHERE car=?", nativeQuery = true)
    public void deleteByCar(Integer car);
}
