package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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
    private String description;
    @NotEmpty(message = "valueBasic is empty")
    private Double valueBasic;
    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Scheduling> schedulings = new HashSet<>();
}
