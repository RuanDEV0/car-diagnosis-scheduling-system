package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Mapper
public interface VehicleMapper {
    public Vehicle toVehicle(VehiclePostRequestBody vehiclePostRequestBody);
    public Vehicle toVehicle(VehiclePutRequestBody vehiclePutRequestBody);
}
