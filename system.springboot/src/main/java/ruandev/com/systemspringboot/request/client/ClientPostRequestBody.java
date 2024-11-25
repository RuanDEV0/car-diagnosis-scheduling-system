package ruandev.com.systemspringboot.request.client;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ClientPostRequestBody {
    private String name;
    private String phone;
    private String email;
}
