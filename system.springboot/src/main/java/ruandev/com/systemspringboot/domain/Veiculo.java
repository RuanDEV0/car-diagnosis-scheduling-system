package ruandev.com.systemspringboot.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
}
