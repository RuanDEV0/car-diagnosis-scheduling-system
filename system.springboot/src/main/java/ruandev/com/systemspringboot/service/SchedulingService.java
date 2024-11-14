package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.SchedulingRepository;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SchedulingService {
    private final SchedulingRepository schedulingRepository;

    public Page<Scheduling> listByStatus(String status, Pageable pageable) {
        return schedulingRepository.findByStatus(status, pageable);
    }

    public Page<Scheduling> listAll(Pageable pageable){
        return schedulingRepository.findAll(pageable);
    }
    @Transactional
    public Scheduling save(SchedulingPostRequestBody schedulingPostRequestBody){
        schedulingPostRequestBody.setStatus(StatusType.PENDENTE);
        if(verificDateOfSchedulling(schedulingPostRequestBody.getData())){
            return schedulingRepository
                    .save(SystemMapper.INSTANCE.toScheduling(schedulingPostRequestBody));

        }else{
            throw new RuntimeException("Date is not Schedulling!");
        }
    }
    public Scheduling findByIdOrThrowException(Long id){
        return schedulingRepository.findById(id).orElseThrow(()-> new RuntimeException("Agendamento not found"));
    }
    public void deleteById(long id){
        schedulingRepository.deleteById(id);
    }
    public void replace(SchedulingPutRequestBody schedulingPutRequestBody){
        Scheduling byIdOrThrowException = this.findByIdOrThrowException(schedulingPutRequestBody.getId());
        Scheduling agendamento = SystemMapper.INSTANCE.toScheduling(schedulingPutRequestBody);
        agendamento.setId(byIdOrThrowException.getId());
        this.schedulingRepository.save(agendamento);
    }
    public boolean verificDateOfSchedulling(LocalDate date){
        return schedulingRepository.findByData(date).size() < 4;
    }
}
