package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.dto.client.ClientPostDto;
import ruandev.com.systemspringboot.dto.client.ClientPutDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {
     Client toClient(ClientPostDto clientPostDto);
     Client toClient(ClientPutDto clientPutDto);
}
