package ruandev.com.systemspringboot.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientPostRequestBody {
    private String name;
    private String telefone;
    private String email;
}
