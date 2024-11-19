package ruandev.com.systemspringboot.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotNull(message = "model is null")
    private String model;
    @Column(length = 4)
    @NotEmpty(message = "year is empty")
    @NotNull(message = "year is null")
    private String year;
    @NotEmpty(message = "name is empty")
    @NotNull(message = "name is null")
    private String name;
    @NotEmpty(message = "km is empty")
    @NotNull(message = "km is null")
    private String km;
    @NotEmpty(message = "brand is empty")
    @NotNull(message = "brand is null")
    private String brand;
    @Column(length = 7, unique = true)
    @NotEmpty(message = "plate is empty")
    @NotNull(message = "plate is null")
    private String plate;
}
