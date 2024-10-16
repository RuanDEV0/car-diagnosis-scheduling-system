package ruandev.com.systemspringboot.request.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AgendamentoPostRequestBody {
    private Long idService;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
