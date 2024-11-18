package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    Servico toServico(ServicoPostRequestBody servicoPostRequestBody);
    Servico toServico(ServicoPutRequestBody servicoPutRequestBody);
}
