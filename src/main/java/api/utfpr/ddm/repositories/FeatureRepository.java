package api.utfpr.ddm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.Feature;
import jakarta.transaction.Transactional;

public interface FeatureRepository extends JpaRepository<Feature,Integer> {
    
    @Query(value = "SELECT * FROM features WHERE car=?", nativeQuery = true)
    public List<Feature> findByCar(Integer car);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM features WHERE car=?", nativeQuery = true)
    public void deleteByCar(Integer car);
}
