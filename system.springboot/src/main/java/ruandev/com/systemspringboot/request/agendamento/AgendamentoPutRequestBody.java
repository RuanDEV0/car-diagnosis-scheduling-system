package ruandev.com.systemspringboot.request.agendamento;

import lombok.Data;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
@Data
public class AgendamentoPutRequestBody {
    private Long id;
    private Long idService;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
