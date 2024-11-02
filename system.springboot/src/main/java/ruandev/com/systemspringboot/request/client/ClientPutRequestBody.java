package ruandev.com.systemspringboot.request.client;

import lombok.Data;

@Data
public class ClientPutRequestBody {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
