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
public abstract class SystemMapper {
    public static final SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    public Veiculo toVeiculo(VeiculoPostRequestBody veiculoPostRequestBody){
        if(veiculoPostRequestBody == null){
            return null;
        }else{
            Veiculo veiculo = Veiculo.builder().ano(veiculoPostRequestBody.getAno()).placa(veiculoPostRequestBody.getPlaca())
                    .marca(veiculoPostRequestBody.getMarca()).modelo(veiculoPostRequestBody.getModelo())
                    .build();
            return veiculo;
        }
    }
    public abstract Veiculo toVeiculo(VeiculoPutRequestBody veiculoPutRequestBody);

    public abstract Agendamento toAgendamento(AgendamentoPostRequestBody agendamentoPostRequestBody);
    public abstract Agendamento toAgendamento(AgendamentoPutRequestBody agendamentoPutRequestBody);

    public abstract Cliente toCliente(ClientePostRequestBody clientePostRequestBody);
    public abstract Cliente toCliente(ClientePutRequestBody clientePutRequestBody);
}
