package usertest.usertest.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import usertest.usertest.model.UserRequest;
import usertest.usertest.model.UserResponce;
import usertest.usertest.repository.UserEntity;
import usertest.usertest.service.UserServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public UserResponce createUser(@RequestBody UserRequest user) {
        return userService.createNewUser(user);
    }

    @GetMapping("/{id}")
    public UserResponce getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
