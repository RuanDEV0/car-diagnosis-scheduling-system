package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.VehicleMapper;
import ruandev.com.systemspringboot.repository.VehicleRepository;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Service
public class VehicleService {
    @Autowired
    private  VehicleRepository vehicleRepository;
    @Autowired
    private VehicleMapper vehicleMapper;

    @Transactional
    public Vehicle save(VehiclePostRequestBody vehiclePostRequestBody){
        return vehicleRepository.save(vehicleMapper.toVehicle(vehiclePostRequestBody));
    }
    public void deleteById(long id){
        vehicleRepository.deleteById(findByIdOrThrowBadRequestException(id).getId());
    }
    public Vehicle findByIdOrThrowBadRequestException(Long id){
        return vehicleRepository.findById(id).orElseThrow(() -> new BadRequestException("vehicle not found!"));
    }
    public void replace(VehiclePutRequestBody vehiclePutRequestBody){
        Vehicle savedVehicle = findByIdOrThrowBadRequestException(vehiclePutRequestBody.getId());
        Vehicle vehicle = vehicleMapper.toVehicle(vehiclePutRequestBody);
        vehicle.setId(savedVehicle.getId());
        vehicleRepository.save(vehicle);
    }
}
