package ruandev.com.systemspringboot.dto.scheduling;

import lombok.Data;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
@Data
public class SchedulingPutRequestBody {
    private Long id;
    private Long idService;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
