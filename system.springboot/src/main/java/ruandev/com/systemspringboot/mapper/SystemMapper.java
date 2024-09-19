package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPostRequestBody;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPutRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePostRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePutRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPostRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPutRequestBody;

@Mapper
public interface SystemMapper {
    SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    Veiculo toVeiculo(VeiculoPostRequestBody veiculoPostRequestBody);
    Veiculo toVeiculo(VeiculoPutRequestBody veiculoPutRequestBody);

    Agendamento toAgendamento(AgendamentoPostRequestBody agendamentoPostRequestBody);
    Agendamento toAgendamento(AgendamentoPutRequestBody agendamentoPutRequestBody);

    Cliente toCliente(ClientePostRequestBody clientePostRequestBody);
    Cliente toCliente(ClientePutRequestBody clientePutRequestBody);
}
