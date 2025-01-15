package ruandev.com.systemspringboot.dto.vehicle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiclePostDto {
    private String model;
    private String year;
    private String km;
    private String brand;
    private String name;
    private String plate;
}
