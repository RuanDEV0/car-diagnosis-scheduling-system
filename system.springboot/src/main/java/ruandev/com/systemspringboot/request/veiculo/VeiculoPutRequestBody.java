package ruandev.com.systemspringboot.request.veiculo;

import lombok.Data;

@Data
public class VeiculoPutRequestBody {
    private Long id;
    private String modelo;
    private int ano;
    private String nome;
    private String km;
    private String marca;
}
