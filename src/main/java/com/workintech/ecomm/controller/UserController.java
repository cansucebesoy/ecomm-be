package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Validated   validated eklemeyi unutma
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 CREATED
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200 OK
    public UserDTO getById(@PathVariable long id){
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200 OK
    public UserDTO delete(@PathVariable long id){
        return userService.delete(id);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

}