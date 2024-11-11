package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.entity.Address;
import com.workintech.ecomm.service.AddressService;
import com.workintech.ecomm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

     private final AddressService addressService;

    @PostMapping("/user/{userId}")
    public AddressDTO save(@PathVariable long userId, @RequestBody AddressDTO addressDTO){
         return addressService.save(userId,addressDTO);
    }

    @DeleteMapping("/{id}")
    public AddressDTO delete(@PathVariable long id){
        return addressService.delete(id);
    }

    @PutMapping
    public AddressDTO update(@RequestBody AddressDTO addressDTO){
        return addressService.update(addressDTO);
    }

    @GetMapping("/user/{userId}")
    public List<AddressDTO> getByUserId(@PathVariable long userId){
        return addressService.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable long id){
        return addressService.getById(id);
    }

}
