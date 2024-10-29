package ruandev.com.systemspringboot.request.Vehicle;

import lombok.Data;

@Data
public class VehiclePutRequestBody {
    private Long id;
    private String modelo;
    private int ano;
    private String nome;
    private String km;
    private String marca;
}
