package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryScheduling;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.util.StatusType;

@Service
@RequiredArgsConstructor
public class SchedulingService {
    private final RepositoryScheduling repositoryScheduling;

    public Page<Scheduling> listByStatus(String status, Pageable pageable) {
        return repositoryScheduling.findByStatus(status, pageable);
    }

    public Page<Scheduling> listAll(Pageable pageable){
        return repositoryScheduling.findAll(pageable);
    }
    public Scheduling save(SchedulingPostRequestBody schedulingPostRequestBody){
        schedulingPostRequestBody.setStatus(StatusType.PENDENTE);
        return repositoryScheduling.save(SystemMapper.INSTANCE.toScheduling(schedulingPostRequestBody));
    }
    public Scheduling findByIdOrThrowException(Long id){
        return repositoryScheduling.findById(id).orElseThrow(()-> new RuntimeException("Agendamento not found"));
    }
    public void deleteById(long id){
        repositoryScheduling.deleteById(id);
    }
    public void replace(SchedulingPutRequestBody schedulingPutRequestBody){
        Scheduling byIdOrThrowException = this.findByIdOrThrowException(schedulingPutRequestBody.getId());
        Scheduling agendamento = SystemMapper.INSTANCE.toScheduling(schedulingPutRequestBody);
        agendamento.setId(byIdOrThrowException.getId());
        this.repositoryScheduling.save(agendamento);
    }
}
