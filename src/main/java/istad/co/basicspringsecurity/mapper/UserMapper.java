package istad.co.basicspringsecurity.mapper;

import istad.co.basicspringsecurity.model.Role;
import istad.co.basicspringsecurity.model.User;
import istad.co.basicspringsecurity.model.dto.UserRequest;
import istad.co.basicspringsecurity.model.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "String")
public class UserMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "userRequesr.email"),
            @Mapping(target = "password", source = "userRequest.password"),
            @Mapping(target = "roles", source = "roles")
    })

    public User toUser(UserRequest userRequest, Set<Role> roles) {
        return null;
    }

    @Mapping(target = "roles", source = "user.roles", qualifiedByName = "mapRoles")
    public UserResponse toUserResponse(User user) {
        return null;
    }

    @Named("mapRoles")
    Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
