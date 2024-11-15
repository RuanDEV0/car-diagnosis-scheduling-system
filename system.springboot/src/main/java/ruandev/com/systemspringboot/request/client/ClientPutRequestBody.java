package ruandev.com.systemspringboot.request.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPutRequestBody {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
