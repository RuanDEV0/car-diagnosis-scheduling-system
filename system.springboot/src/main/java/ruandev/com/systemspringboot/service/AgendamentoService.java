package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryAgendamento;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPostRequestBody;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPutRequestBody;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final RepositoryAgendamento repositoryAgendamento;

    public Page<Agendamento> listAll(Pageable pageable){
        return repositoryAgendamento.findAll(pageable);
    }
    public Agendamento save(AgendamentoPostRequestBody agendamentoPostRequestBody){
        return repositoryAgendamento.save(SystemMapper.INSTANCE.toAgendamento(agendamentoPostRequestBody));
    }
    public Agendamento findByIdOrThrowException(Long id){
        return repositoryAgendamento.findById(id).orElseThrow();
    }
    public void deleteAll(){
        repositoryAgendamento.deleteAll();
    }
    public void replace(AgendamentoPutRequestBody agendamentoPutRequestBody){
        Agendamento savedAgendamento = findByIdOrThrowException(agendamentoPutRequestBody.getId());
        Agendamento agendamento = SystemMapper.INSTANCE.toAgendamento(agendamentoPutRequestBody);
        agendamento.setId(savedAgendamento.getId());
        repositoryAgendamento.save(agendamento);
    }

}
