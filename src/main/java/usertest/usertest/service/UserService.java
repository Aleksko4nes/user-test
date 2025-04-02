package usertest.usertest.service;


import usertest.usertest.model.UserRequest;
import usertest.usertest.model.UserResponce;

import java.util.List;

public interface UserService {
    UserResponce createNewUser(UserRequest userRequest);
    UserResponce getUser(long id);
    UserResponce updateUser(long id, UserRequest userRequest);
    String deleteUser(long id);
    List<UserResponce> getAllUsers();
}
