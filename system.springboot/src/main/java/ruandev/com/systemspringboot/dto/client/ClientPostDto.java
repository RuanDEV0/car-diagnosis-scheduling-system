package ruandev.com.systemspringboot.dto.client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientPostDto {
    private String name;
    private String phone;
    private String email;
}
