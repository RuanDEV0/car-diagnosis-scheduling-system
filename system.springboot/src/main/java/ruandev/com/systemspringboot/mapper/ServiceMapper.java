package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    Service toService(ServicePostRequestBody servicePostRequestBody);
    Service toService(ServicePutRequestBody servicePutRequestBody);
}
