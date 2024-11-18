package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.SchedulingMapper;
import ruandev.com.systemspringboot.repository.SchedulingRepository;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Service
public class SchedulingService {
    @Autowired
    private  SchedulingRepository schedulingRepository;
    @Autowired
    private SchedulingMapper schedulingMapper;

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
                    .save(schedulingMapper.toScheduling(schedulingPostRequestBody));

        }else{
            throw new RuntimeException("Date is not Schedulling!");
        }
    }
    public Scheduling findByIdOrThrowException(Long id){
        return schedulingRepository.findById(id).orElseThrow(()-> new BadRequestException("scheduling not found"));
    }
    public void deleteById(long id){
        schedulingRepository.deleteById(id);
    }
    public void replace(SchedulingPutRequestBody schedulingPutRequestBody){
        Scheduling byIdOrThrowException = this.findByIdOrThrowException(schedulingPutRequestBody.getId());
        Scheduling agendamento = schedulingMapper.toScheduling(schedulingPutRequestBody);
        agendamento.setId(byIdOrThrowException.getId());
        this.schedulingRepository.save(agendamento);
    }
    public boolean verificDateOfSchedulling(LocalDate date){
        return schedulingRepository.findByData(date).size() < 4;
    }
}
