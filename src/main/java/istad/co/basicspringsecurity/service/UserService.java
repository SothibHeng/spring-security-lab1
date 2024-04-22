package istad.co.basicspringsecurity.service;

import istad.co.basicspringsecurity.model.dto.UserRequest;
import istad.co.basicspringsecurity.model.dto.UserResponse;


public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
