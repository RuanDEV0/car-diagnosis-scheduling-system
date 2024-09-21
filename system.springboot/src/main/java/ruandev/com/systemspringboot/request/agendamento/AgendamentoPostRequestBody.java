package ruandev.com.systemspringboot.request.agendamento;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AgendamentoPostRequestBody {
    private LocalDate data;
    private String status;
    private Integer veiculoId;
}
