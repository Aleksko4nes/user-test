package usertest.usertest.model;

import lombok.Data;

@Data
public class UserRequest {
    String firstName;
    String lastName;
    int tlfNumber;
    long companyId;
}
