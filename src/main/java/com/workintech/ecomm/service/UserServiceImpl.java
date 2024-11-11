package com.workintech.ecomm.service;

import com.workintech.ecomm.dto.AddressDTO;
import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.Address;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.mapper.UserMapper;
import com.workintech.ecomm.repository.UserRepository;
import com.workintech.ecomm.util.GenericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        return GenericUtil.saveEntity(userDTO, userMapper::userDTOToUser, userMapper::userToUserDTO, userRepository);

    }

    @Override
    public UserDTO getById(long id) {
        User user = this.getEntityById(id);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO delete(long id) {
        User user = userRepository.deleteById(id);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return GenericUtil.saveEntity(userDTO, userMapper::userDTOToUser, userMapper::userToUserDTO, userRepository);
    }

    @Override
    public User getEntityById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EcommException("user with given id is not exist." + id, HttpStatus.NOT_FOUND));
    }
}