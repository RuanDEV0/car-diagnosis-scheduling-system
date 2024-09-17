package ruandev.com.systemspringboot.request.cliente;

import lombok.Data;

@Data
public class ClientePutRequestBody {
    private Long id;
    private String name;
    private String telefone;
}
