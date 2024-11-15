package ruandev.com.systemspringboot.request.Vehicle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiclePutRequestBody {
    private Long id;
    private String model;
    private String year;
    private String name;
    private String km;
    private String brand;
}
