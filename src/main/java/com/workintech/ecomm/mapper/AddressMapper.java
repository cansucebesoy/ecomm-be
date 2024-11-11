package com.workintech.ecomm.mapper;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO addressToAddressDTO(Address address);

    List<AddressDTO> addressListToAddressDTOList(List<Address> addressList);

    Address addressDTOToAddress(AddressDTO addressDTO);

    List<Address> addressDTOListToAddressList(List<AddressDTO> addressDTOList);


}
