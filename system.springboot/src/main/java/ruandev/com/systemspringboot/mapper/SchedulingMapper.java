package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;

@Mapper(componentModel = "spring")
public interface SchedulingMapper {
    Scheduling toScheduling(SchedulingPostRequestBody schedulingPostRequestBody);
    Scheduling toScheduling(SchedulingPutRequestBody schedulingPutRequestBody);
}
