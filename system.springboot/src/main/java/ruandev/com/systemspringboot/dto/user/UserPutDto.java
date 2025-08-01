package ruandev.com.systemspringboot.dto.user;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class UserPutDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
