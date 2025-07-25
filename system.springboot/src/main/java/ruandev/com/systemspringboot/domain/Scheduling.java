package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @NotEmpty(message = "date is empty")
    private LocalDate data;
    @NotEmpty(message = "time is empty")
    private LocalTime time;
    @NotEmpty(message = "services is empty")
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "service_scheduling",
            joinColumns = @JoinColumn(name = "id_scheduling"),
            inverseJoinColumns = @JoinColumn(name = "id_service")

    )
    private Set<Servico> services = new HashSet<>();
    /*to alter type of field status*/
    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.PENDENTE;
    @ManyToOne()
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;
    @NotEmpty(message = "client is empty")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    @PrePersist
    private void prePersist() {
        if(status == null){
            status = StatusType.PENDENTE;
        }
    }
}
