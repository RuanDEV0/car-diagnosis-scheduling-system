package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePostDto;
import ruandev.com.systemspringboot.dto.vehicle.VehiclePutDto;
import ruandev.com.systemspringboot.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@Valid @RequestBody VehiclePostDto vehiclePostDto) {
        return new ResponseEntity<>(vehicleService.save(vehiclePostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VehiclePutDto vehiclePutDto) {
        vehicleService.replace(vehiclePutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        vehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
