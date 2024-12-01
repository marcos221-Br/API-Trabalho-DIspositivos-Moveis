package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.exceptions.NotFoundException;
import api.utfpr.ddm.models.Address;
import api.utfpr.ddm.repositories.AddressRepository;
import api.utfpr.ddm.repositories.UserRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private UserRepository userRepository;

    private Address address;

    public Address createAddress(Address address){
        return this.addressRepository.save(address);
    }

    public List<Address> getAllAddresses(){
        return this.addressRepository.findAll();
    }

    public Address getAddress(Integer id){
        address = this.addressRepository.findAddressById(id);
        if(address != null){
            return address;
        }else{
            throw new NotFoundException("Endereço não encontrado!");
        }
    }

    public Address updateAddress(Integer id, Address address){
        address.setId(id);
        return this.addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        this.userRepository.deleteByAddress(id);
        this.addressRepository.deleteById(id);
    }
}
