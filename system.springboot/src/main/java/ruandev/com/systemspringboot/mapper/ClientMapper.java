package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;

@Mapper
public interface ClientMapper {
    public Client toClient(ClientPostRequestBody clientPostRequestBody);
    public Client toClient(ClientPutRequestBody clientPutRequestBody);
}
