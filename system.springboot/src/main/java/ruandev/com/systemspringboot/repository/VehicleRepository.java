package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long > {
    boolean existsByPlate(String plate);
}
