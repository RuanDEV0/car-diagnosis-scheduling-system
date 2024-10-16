package ruandev.com.systemspringboot.request.veiculo;

import lombok.Data;

@Data
public class VeiculoPostRequestBody {
    private String modelo;
    private int ano;
    private String km;
    private String marca;
    private String nome;
}
