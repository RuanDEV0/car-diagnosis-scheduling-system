package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientPostRequestBody clientPostRequestBody);

    Client toClient(ClientPutRequestBody clientPutRequestBody);
}
