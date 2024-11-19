package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDate data;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "service_scheduling",
            joinColumns = @JoinColumn(name = "id_scheduling"),
            inverseJoinColumns = @JoinColumn(name = "id_service")

    )
    private List<Servico> serviceList;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;
}
