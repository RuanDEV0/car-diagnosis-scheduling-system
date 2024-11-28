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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "name is empty")
    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "description is empty")
    private String shortDescription;
    @NotEmpty(message = "valueBasic is empty")
    private Double valueBasic;

}
