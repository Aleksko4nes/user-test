package usertest.usertest.repository;


import lombok.Data;

@Data
public class UserEntity {
    long id;
    String firstName;
    String lastName;
    int tlfNumber;
    long companyId;


}
