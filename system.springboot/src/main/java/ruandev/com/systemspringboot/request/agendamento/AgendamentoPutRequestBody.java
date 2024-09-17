package ruandev.com.systemspringboot.request.agendamento;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AgendamentoPutRequestBody {
    private Long id;
    private LocalDate data;
}
