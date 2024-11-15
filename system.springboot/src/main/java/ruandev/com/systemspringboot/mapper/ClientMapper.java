package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;

@Mapper(componentModel = "spring")
public interface ClientMapper {
     Client toClient(ClientPostRequestBody clientPostRequestBody);
     Client toClient(ClientPutRequestBody clientPutRequestBody);
}
