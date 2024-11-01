package ruandev.com.systemspringboot.request.Vehicle;

import lombok.Data;

@Data
public class VehiclePostRequestBody {
    private String model;
    private String year;
    private String km;
    private String brand;
    private String name;
}
