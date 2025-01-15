package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.dto.service.ServicoPostDto;
import ruandev.com.systemspringboot.dto.service.ServicoPutDto;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    Servico toServico(ServicoPostDto servicoPostDto);
    Servico toServico(ServicoPutDto servicoPutDtoDto);
}
