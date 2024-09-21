package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DialectOverride;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ruandev.com.systemspringboot.auxiliar.StatusAgendamento;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String status;
    private Integer veiculoId;
}
