package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
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
    @Column(unique = true)
    private String model;
    @Column(unique = true, length = 4)
    private String year;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String km;
    @Column(unique = true)
    private String brand;
}
