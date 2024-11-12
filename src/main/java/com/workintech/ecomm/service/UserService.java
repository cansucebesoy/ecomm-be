package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.Address;
import com.workintech.ecomm.entity.User;

import java.util.List;

public interface UserService {

    UserDTO getById(long id);
    UserDTO save(UserDTO userDTO);
    UserDTO delete(long id);
    UserDTO update(UserDTO userDTO);
    User getEntityById(long id);
    List<AddressDTO> getUserAddresses(long userId);
}
