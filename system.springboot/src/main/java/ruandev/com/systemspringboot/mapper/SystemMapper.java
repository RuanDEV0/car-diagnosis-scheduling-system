package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPostRequestBody;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPutRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePostRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPostRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPutRequestBody;

@Mapper
public abstract class SystemMapper {
    public static final SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    public abstract Veiculo toVeiculo(VeiculoPostRequestBody veiculoPostRequestBody);
    public abstract Veiculo toVeiculo(VeiculoPutRequestBody veiculoPutRequestBody);

    public abstract Agendamento toAgendamento(AgendamentoPostRequestBody agendamentoPostRequestBody);
    public abstract Agendamento toAgendamento(AgendamentoPutRequestBody agendamentoPutRequestBody);

    public abstract Cliente toCliente(ClientePostRequestBody clientePostRequestBody);
    public abstract Cliente toCliente(ClientePutRequestBody clientePutRequestBody);

    public abstract Servico toServico(ServicoPostRequestBody servicoPostRequestBody);
    public abstract Servico toServico(ServicoPutRequestBody servicoPutRequestBody);
}
