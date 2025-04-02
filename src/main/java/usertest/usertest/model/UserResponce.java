package usertest.usertest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponce {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final int tlfNumber;
    private final long companyId;
}
