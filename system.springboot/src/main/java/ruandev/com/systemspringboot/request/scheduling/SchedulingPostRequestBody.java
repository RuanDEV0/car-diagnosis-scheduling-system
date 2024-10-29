package ruandev.com.systemspringboot.request.scheduling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingPostRequestBody {
    private Long idService;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
