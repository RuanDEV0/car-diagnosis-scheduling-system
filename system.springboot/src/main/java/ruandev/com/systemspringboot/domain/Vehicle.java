package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "model is empty")
    private String model;
    @Column(length = 4)
    @NotEmpty(message = "year is empty")
    private String year;
    @NotEmpty(message = "name is empty")
    private String name;
    @NotEmpty(message = "km is empty")
    private String km;
    @NotEmpty(message = "brand is empty")
    private String brand;
    @Column(length = 7, unique = true)
    @NotEmpty(message = "plate is empty")
    private String plate;
}
