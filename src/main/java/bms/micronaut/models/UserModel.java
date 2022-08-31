package bms.micronaut.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {


    private String email;

    private String address;

    private String password;


}
