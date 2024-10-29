package ruandev.com.systemspringboot.request.Vehicle;

import lombok.Data;

@Data
public class VehiclePostRequestBody {
    private String modelo;
    private int ano;
    private String km;
    private String marca;
    private String nome;
}
