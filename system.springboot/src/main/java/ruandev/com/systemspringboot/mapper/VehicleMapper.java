package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePostDto;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePutDto;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toVehicle(VehiclePostDto vehiclePostDto);
    Vehicle toVehicle(VehiclePutDto vehiclePutDto);
}
