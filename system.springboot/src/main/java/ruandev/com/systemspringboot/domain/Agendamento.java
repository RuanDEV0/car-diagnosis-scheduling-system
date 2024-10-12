package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.ParamDef;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ruandev.com.systemspringboot.auxiliar.StatusAgendamento;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Long idService;
    private StatusType status;
    private Long veiculoId;

}
