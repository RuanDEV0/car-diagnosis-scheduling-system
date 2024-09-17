package ruandev.com.systemspringboot.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Agendamento {
    private LocalDate data;
}
