package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.dto.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.dto.service.ServicoPutRequestBody;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    Servico toServico(ServicoPostRequestBody servicoPostRequestBody);
    Servico toServico(ServicoPutRequestBody servicoPutRequestBody);
}
