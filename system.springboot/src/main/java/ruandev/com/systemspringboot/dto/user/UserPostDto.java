package ruandev.com.systemspringboot.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import ruandev.com.systemspringboot.domain.Role;

import java.util.List;

@Builder
@Data
public class UserPostDto {

    @NotBlank(message = "name is not null and contains three caracter non-whitespace  ")
    @Size(min = 3, message = "min three caracterer required")
    private String name;
    @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[0-9])[0-9]{3}\\-?[0-9]{4}$", message = "incorrect format phone")
    private String phone;
    @Email
    @NotBlank
    private String email;
    @NotBlank(message = "password is not null and non-whitespaces")
    private String password;
    @NotEmpty(message = "roles is not empty")
    @Size(min = 1, message = "there must be at least one")
    private List<Role> roles;


}
