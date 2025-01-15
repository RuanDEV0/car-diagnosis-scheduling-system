package ruandev.com.systemspringboot.dto.vehicle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehiclePutDto {
    private Long id;
    private String model;
    private String year;
    private String name;
    private String km;
    private String brand;
    private String plate;
}
