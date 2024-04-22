package istad.co.basicspringsecurity.restcontroller;

import istad.co.basicspringsecurity.model.dto.UserRequest;
import istad.co.basicspringsecurity.model.dto.UserResponse;
import istad.co.basicspringsecurity.service.UserService;
import istad.co.basicspringsecurity.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final UserService userService;

    @PostMapping("/register")
    public BaseResponse<UserResponse> createNewUser(@RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }
}
