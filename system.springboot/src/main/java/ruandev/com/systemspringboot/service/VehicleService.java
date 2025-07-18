package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.VehicleMapper;
import ruandev.com.systemspringboot.repository.VehicleRepository;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePostDto;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePutDto;
import ruandev.com.systemspringboot.validation.VehicleValidator;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final VehicleValidator vehicleValidator;

    @Transactional
    public Vehicle save(VehiclePostDto vehiclePostDto){
        if(vehicleValidator.validateByPlate(vehiclePostDto.getPlate())) {
            throw new BadRequestException("Vehicle with plate exists");
        }
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
