package ruandev.com.systemspringboot.request.agendamento;

import jakarta.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoPostRequestBody {
    @ForeignKey
    private Long idService;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
