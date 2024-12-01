package api.utfpr.ddm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.ddm.models.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
    
    @Query(value = "SELECT * FROM addresses WHERE id=?", nativeQuery = true)
    public Address findAddressById(Integer id);
}
