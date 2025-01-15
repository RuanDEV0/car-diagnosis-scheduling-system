package ruandev.com.systemspringboot.dto.scheduling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingPostRequestBody {
    private Long id;
    private LocalDate data;
    private StatusType status;
    private Integer veiculoId;
}
