package usertest.usertest.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import usertest.usertest.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
@RequiredArgsConstructor
public class UserRepositoryMap implements UserRepository{

    private final Map<Long, UserEntity> users = new ConcurrentHashMap<>();

    @Override
    public UserEntity findUserById(long id) {
        UserEntity user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return users.put(user.getId(), user);
    }

//    @Override
//    public UserEntity updateUser(UserEntity user) {
//        UserEntity userEntity = users.get(user.getId());
//        userEntity.setFirstName();
//        return null;
//    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return new ArrayList<>(users.values());
    }
}
