package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.repository.VehicleRepository;

@Component
@RequiredArgsConstructor
public class VehicleValidator {
    private final VehicleRepository repository;

    public boolean validateByPlate(String plate) {
        return repository.existsByPlate(plate);
    }

}
