package istad.co.basicspringsecurity.service;

import istad.co.basicspringsecurity.mapper.UserMapper;
import istad.co.basicspringsecurity.model.Role;
import istad.co.basicspringsecurity.model.User;
import istad.co.basicspringsecurity.model.dto.UserRequest;
import istad.co.basicspringsecurity.model.dto.UserResponse;
import istad.co.basicspringsecurity.repository.RoleRepository;
import istad.co.basicspringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // check email
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already existed!");
        }
        Set<Role> roles = new HashSet<>();
        // check roles
        userRequest.roles().forEach(
                r -> {
                    var roleObj = roleRepository
                            .findByName(r)
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.BAD_REQUEST,
                                    "Role" + r + "not found!"
                            ));
                    roles.add(roleObj);
                }
        );
        User newUser = userMapper.toUser(userRequest, roles);
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        userRepository.save(newUser);
        return userMapper.toUserResponse(newUser);
    }
}