package ruandev.com.systemspringboot.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserPostDto {
    private String name;
    private String phone;
    private String email;
    private String password;
}
