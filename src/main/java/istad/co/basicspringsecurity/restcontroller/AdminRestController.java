package istad.co.basicspringsecurity.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admins")
public class AdminRestController {

    @GetMapping
    public String getAllUser() {
        return "There are all the user!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return "User with id = " + id + " delete successfully!";
    }
}
