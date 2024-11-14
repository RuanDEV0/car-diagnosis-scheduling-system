package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.VehicleRepository;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    @Transactional(readOnly = true)

    public Page<Vehicle> listAll(Pageable pageable){
        return vehicleRepository.findAll(pageable);
    }
    @Transactional
    public Vehicle save(VehiclePostRequestBody vehiclePostRequestBody){
        return vehicleRepository.save(SystemMapper.INSTANCE.toVehicle(vehiclePostRequestBody));
    }
    public void deleteById(long id){
        vehicleRepository.deleteById(id);
    }
    public Vehicle findByIdOrThrowException(Long id){
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("anime not found!"));
    }
    public void replace(VehiclePutRequestBody vehiclePutRequestBody){
        Vehicle savedVehicle = findByIdOrThrowException(vehiclePutRequestBody.getId());
        Vehicle vehicle = SystemMapper.INSTANCE.toVehicle(vehiclePutRequestBody);
        vehicle.setId(savedVehicle.getId());
        vehicleRepository.save(vehicle);
    }
}
