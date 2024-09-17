package ruandev.com.systemspringboot.request.veiculo;

import lombok.Data;

@Data
public class VeiculoPutRequestBody {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
}
