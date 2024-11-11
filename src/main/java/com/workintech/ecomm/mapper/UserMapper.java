package com.workintech.ecomm.mapper;


import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    List<UserDTO> userListToUserDTOList(List<User> users);

    User userDTOToUser(UserDTO userDTO);

    List<User> userDTOListToUserList(List<UserDTO> userDTOList);

}
