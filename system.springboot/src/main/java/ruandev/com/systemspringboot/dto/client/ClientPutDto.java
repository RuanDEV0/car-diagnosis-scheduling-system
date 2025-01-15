package ruandev.com.systemspringboot.dto.client;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class ClientPutDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
