package ruandev.com.systemspringboot.request.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ClientePostRequestBody {
    private String name;
    private String telefone;
    private String email;
}
