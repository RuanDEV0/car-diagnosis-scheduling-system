package ruandev.com.systemspringboot.dto.scheduling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ruandev.com.systemspringboot.util.StatusType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingUpdateStatusDto {
    private StatusType status;
    private Long idScheduling;
}
