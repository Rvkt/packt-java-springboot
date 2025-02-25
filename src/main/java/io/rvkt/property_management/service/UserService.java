package io.rvkt.property_management.service;


import io.rvkt.property_management.dto.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);

}
