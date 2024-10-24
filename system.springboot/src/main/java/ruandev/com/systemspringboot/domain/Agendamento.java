package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    @JoinColumn()
    private Long idService;
    private StatusType status;
    private Long veiculoId;

}
