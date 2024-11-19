package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_shedulling")
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "date is null")
    @NotEmpty(message = "date is empty")
    private LocalDate data;
    @NotNull(message = "services is null")
    @NotEmpty(message = "services is empty")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "service_scheduling",
            joinColumns = @JoinColumn(name = "id_scheduling"),
            inverseJoinColumns = @JoinColumn(name = "id_service")

    )
    private List<Servico> serviceList;
    @ColumnDefault(value = "PENDENTE")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @NotNull(message = "client is null")
    @NotEmpty(message = "client is empty")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;
}
