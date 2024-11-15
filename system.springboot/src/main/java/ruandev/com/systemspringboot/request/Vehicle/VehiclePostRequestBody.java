package ruandev.com.systemspringboot.request.Vehicle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiclePostRequestBody {
    private String model;
    private String year;
    private String km;
    private String brand;
    private String name;
}
