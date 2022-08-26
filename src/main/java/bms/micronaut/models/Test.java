package bms.micronaut.models;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedEntity
public class Test {

    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    @NonNull
    private String username;
    private String password;
}
