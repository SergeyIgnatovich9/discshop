package org.selenium.dto;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserAccount createFakeAccount() {
        return new UserAccount(
                new Faker().name().firstName(),
                new Faker().name().lastName(),
                new Faker().internet().emailAddress(),
                new Faker().internet().password(8,10,true, true));
    }
}
