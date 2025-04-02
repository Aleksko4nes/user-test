package usertest.usertest.repository;


import java.util.List;

public interface UserRepository {
    UserEntity findUserById(long id);
    UserEntity createUser(UserEntity user);

    void deleteUser(Long id);
    List<UserEntity> findAllUsers();
}
