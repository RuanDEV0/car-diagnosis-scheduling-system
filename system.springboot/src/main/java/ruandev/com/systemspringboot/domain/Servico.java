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
@Table(name = "tb_service")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "name is empty")
    @NotNull(message = "name is null")
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "description is empty")
    @NotNull(message = "description is null")
    private String description;
    @NotEmpty(message = "valueBasic is empty")
    @NotNull(message = "valueBasic is null")
    private Double valueBasic;

}
