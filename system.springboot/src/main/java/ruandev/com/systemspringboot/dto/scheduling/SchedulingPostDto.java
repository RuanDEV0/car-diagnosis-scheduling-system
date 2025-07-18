package ruandev.com.systemspringboot.dto.scheduling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulingPostDto {
    private Long id;
    private LocalDate data;
    private LocalTime tIme;
    @Builder.Default
    private StatusType status =  StatusType.PENDENTE;
    private Long veiculoId;
}
