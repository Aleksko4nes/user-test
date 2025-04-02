package usertest.usertest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usertest.usertest.model.UserRequest;
import usertest.usertest.model.UserResponce;
import usertest.usertest.repository.UserEntity;
import usertest.usertest.repository.UserRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AtomicLong idGenerator = new AtomicLong(0);

    private long generateId() {
        return idGenerator.incrementAndGet();
    }

    @Override
    public UserResponce createNewUser(UserRequest userRequest) {
        long id = generateId();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setTlfNumber(userRequest.getTlfNumber());
        userEntity.setCompanyId(userRequest.getCompanyId());
        userRepository.createUser(userEntity);

        return new UserResponce(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getTlfNumber(),
                userEntity.getCompanyId());
    }

    @Override
    public UserResponce getUser(long id) {
        UserEntity userEntity = userRepository.findUserById(id);
        return new UserResponce(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getTlfNumber(),
                userEntity.getCompanyId());
    }

    @Override
    public UserResponce updateUser(long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteUser(id);
        return "User deleted";
    }

    @Override
    public List<UserResponce> getAllUsers() {
       return null;
    }
}
