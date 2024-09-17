package ruandev.com.systemspringboot.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
}
