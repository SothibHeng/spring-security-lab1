package istad.co.basicspringsecurity.model.dto;

import lombok.Builder;
import java.util.Set;
@Builder
public record UserRequest(
        String email,
        String password,
        Set<String> roles
) {}
