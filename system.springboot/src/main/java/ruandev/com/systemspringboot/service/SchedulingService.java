package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryScheduling;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

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
    @Transactional
    public Scheduling save(SchedulingPostRequestBody schedulingPostRequestBody){
        schedulingPostRequestBody.setStatus(StatusType.PENDENTE);
        if(verificDateOfSchedulling(schedulingPostRequestBody.getData())){
            return repositoryScheduling
                    .save(SystemMapper.INSTANCE.toScheduling(schedulingPostRequestBody));

        }else{
            throw new RuntimeException("Date is not Schedulling!");
        }
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
    public boolean verificDateOfSchedulling(LocalDate date){
        return repositoryScheduling.findByData(date).size() < 4;
    }
}
