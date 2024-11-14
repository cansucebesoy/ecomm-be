package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.entity.Address;
import com.workintech.ecomm.service.AddressService;
import com.workintech.ecomm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable long id){
        return addressService.getById(id);
    }

}
