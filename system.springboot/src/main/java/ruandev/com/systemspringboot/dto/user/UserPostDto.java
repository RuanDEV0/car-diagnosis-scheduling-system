package ruandev.com.systemspringboot.dto.user;

import lombok.Builder;
import lombok.Data;
import ruandev.com.systemspringboot.domain.Role;

import java.util.List;
import java.util.Set;

@Builder
@Data
public class UserPostDto {
    private String name;
    private String phone;
    private String email;
    private String password;
    private List<Role> roles;
}
