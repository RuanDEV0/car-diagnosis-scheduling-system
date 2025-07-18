package ruandev.com.systemspringboot.dto.scheduling;

import lombok.Data;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SchedulingPutDto {
    private Long id;
    private Long idService;
    private LocalDate data;
    private LocalTime time;
    private StatusType status;
    private Integer veiculoId;
}
