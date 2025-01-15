package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingPostDto;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingPutDto;

@Mapper(componentModel = "spring")
public interface SchedulingMapper {
    Scheduling toScheduling(SchedulingPostDto schedulingPostDto);
    Scheduling toScheduling(SchedulingPutDto schedulingPutDto);
}
