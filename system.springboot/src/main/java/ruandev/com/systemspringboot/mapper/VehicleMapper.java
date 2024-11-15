package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toVehicle(VehiclePostRequestBody vehiclePostRequestBody);
    Vehicle toVehicle(VehiclePutRequestBody vehiclePutRequestBody);
}
