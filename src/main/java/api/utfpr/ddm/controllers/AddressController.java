package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.AddressDto;
import api.utfpr.ddm.dtos.AddressResponseDto;
import api.utfpr.ddm.models.Address;
import api.utfpr.ddm.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @PostMapping
    public AddressResponseDto createAddress(@RequestBody AddressDto addressDto){
        return AddressResponseDto.addressDto(this.addressService.createAddress(addressDto.addressObject()));
    }

    @GetMapping
    public List<AddressResponseDto> getAllAddresses(){
        List<Address> addresses = this.addressService.getAllAddresses();
        List<AddressResponseDto> addressResponseDtos = new ArrayList<>();
        for (Address address : addresses){
            addressResponseDtos.add(AddressResponseDto.addressDto(address));
        }
        return addressResponseDtos;
    }

    @GetMapping("/{id}")
    public AddressResponseDto getAddress(@PathVariable Integer id){
        return AddressResponseDto.addressDto(this.addressService.getAddress(id));
    }

    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        return AddressResponseDto.addressDto(this.addressService.updateAddress(id,addressDto.addressObject()));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        this.addressService.deleteAddress(id);
    }
}
