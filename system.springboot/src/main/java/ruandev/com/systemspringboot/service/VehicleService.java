package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.VehicleMapper;
import ruandev.com.systemspringboot.repository.VehicleRepository;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePostDto;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePutDto;

@Service
public class VehicleService {
    @Autowired
    private  VehicleRepository vehicleRepository;
    @Autowired
    private VehicleMapper vehicleMapper;

    @Transactional
    public Vehicle save(VehiclePostDto vehiclePostDto){
        return vehicleRepository.save(vehicleMapper.toVehicle(vehiclePostDto));
    }
    public void deleteById(long id){
        vehicleRepository.deleteById(findByIdOrThrowBadRequestException(id).getId());
    }
    public Vehicle findByIdOrThrowBadRequestException(Long id){
        return vehicleRepository.findById(id).orElseThrow(() -> new BadRequestException("vehicle not found!"));
    }
    public void replace(VehiclePutDto vehiclePutDto){
        Vehicle savedVehicle = findByIdOrThrowBadRequestException(vehiclePutDto.getId());
        Vehicle vehicle = vehicleMapper.toVehicle(vehiclePutDto);
        vehicle.setId(savedVehicle.getId());
        vehicleRepository.save(vehicle);
    }
}
