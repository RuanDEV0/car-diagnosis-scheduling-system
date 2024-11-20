package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;
import ruandev.com.systemspringboot.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Page<Vehicle>> findAll(Pageable pegeable){
        return ResponseEntity.ok(vehicleService.listAll(pegeable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@Valid @RequestBody VehiclePostRequestBody vehiclePostRequestBody){
        return new ResponseEntity<>(vehicleService.save(vehiclePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VehiclePutRequestBody vehiclePutRequestBody){
        vehicleService.replace(vehiclePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        vehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
