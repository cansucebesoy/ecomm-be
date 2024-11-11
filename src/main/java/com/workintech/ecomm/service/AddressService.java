package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.entity.Address;

import java.util.List;

public interface AddressService {

   AddressDTO save(long userId, AddressDTO addressDTO);
   AddressDTO delete(long id);
   AddressDTO update(AddressDTO addressDTO);
   List<AddressDTO> getByUserId(long userId);
   AddressDTO getById(long id);



}
