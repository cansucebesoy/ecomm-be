package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.Address;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.AddressMapper;
import com.workintech.ecomm.repository.AddressRepository;
import com.workintech.ecomm.util.GenericUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    private UserService userService;
    private AddressMapper addressMapper;

   @Override
    public AddressDTO save(long userId, AddressDTO addressDTO) {
       User foundUser = userService.getEntityById(userId);
       Address address = addressMapper.addressDTOToAddress(addressDTO);
       foundUser.addAddress(address);
       address.setUser(foundUser);
       Address savedAddress = addressRepository.save(address);
       return addressMapper.addressToAddressDTO(savedAddress);
   }

    @Override
    public AddressDTO delete(long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EcommException("Address not found with id: " + id, HttpStatus.NOT_FOUND));
        addressRepository.delete(address);
        return addressMapper.addressToAddressDTO(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return GenericUtil.saveEntity(addressDTO, addressMapper::addressDTOToAddress, addressMapper::addressToAddressDTO, addressRepository);

    }

    @Override
    public List<AddressDTO> getByUserId(long userId) {
       List<Address> addressList = addressRepository.findByUserId(userId);
       return addressMapper.addressListToAddressDTOList(addressList);
    }

    @Override
    public AddressDTO getById(long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EcommException("Address not found with id: " + id, HttpStatus.NOT_FOUND));
        return addressMapper.addressToAddressDTO(address);
    }

}
