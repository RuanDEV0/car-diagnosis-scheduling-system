package ruandev.com.systemspringboot.request.client;

import lombok.*;


@Builder
@Data
public class ClientPostRequestBody {
    private String name;
    private String phone;
    private String email;
}
