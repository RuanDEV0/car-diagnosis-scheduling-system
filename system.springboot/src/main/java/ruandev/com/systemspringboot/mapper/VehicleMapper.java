package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.dto.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.dto.Vehicle.VehiclePutRequestBody;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toVehicle(VehiclePostRequestBody vehiclePostRequestBody);
    Vehicle toVehicle(VehiclePutRequestBody vehiclePutRequestBody);
}
