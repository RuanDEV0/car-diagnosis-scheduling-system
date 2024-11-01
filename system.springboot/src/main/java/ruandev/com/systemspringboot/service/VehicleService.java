package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryVehicle;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final RepositoryVehicle repositoryVehicle;

    public Page<Vehicle> listAll(Pageable pageable){
        return repositoryVehicle.findAll(pageable);
    }
    public Vehicle save(VehiclePostRequestBody vehiclePostRequestBody){
        return repositoryVehicle.save(SystemMapper.INSTANCE.toVehicle(vehiclePostRequestBody));
    }
    public void deleteById(long id){
        repositoryVehicle.deleteById(id);
    }
    public Vehicle findByIdOrThrowException(Long id){
        return repositoryVehicle.findById(id).orElseThrow(() -> new RuntimeException("anime not found!"));
    }
    public void replace(VehiclePutRequestBody vehiclePutRequestBody){
        Vehicle savedVehicle = findByIdOrThrowException(vehiclePutRequestBody.getId());
        Vehicle vehicle = SystemMapper.INSTANCE.toVehicle(vehiclePutRequestBody);
        vehicle.setId(savedVehicle.getId());
        repositoryVehicle.save(vehicle);
    }
}
