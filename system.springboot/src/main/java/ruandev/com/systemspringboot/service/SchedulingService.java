package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.SchedulingMapper;
import ruandev.com.systemspringboot.repository.SchedulingRepository;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingPostDto;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingPutDto;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingUpdateStatusDto;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;

@Service
public class SchedulingService {
    @Autowired
    private  SchedulingRepository schedulingRepository;
    @Autowired
    private SchedulingMapper schedulingMapper;

    public Page<Scheduling> listByStatus(StatusType status, Pageable pageable) {
        return schedulingRepository.findByStatus(status, pageable);
    }

    @Transactional
    public Scheduling save(SchedulingPostDto schedulingPostDto){
        schedulingPostDto.setStatus(StatusType.PENDENTE);
        if(verificDateOfSchedulling(schedulingPostDto.getData())){
            return schedulingRepository
                    .save(schedulingMapper.toScheduling(schedulingPostDto));

        }else{
            throw new BadRequestException("Date is not Schedulling!");
        }
    }
    public Scheduling findByIdOrThrowBadRequestException(Long id){
        return schedulingRepository.findById(id).orElseThrow(()-> new BadRequestException("scheduling not found"));
    }
    public void deleteById(long id){
        schedulingRepository.deleteById(this.findByIdOrThrowBadRequestException(id).getId());
    }
    @Transactional
    public void replace(SchedulingPutDto schedulingPutDto){
        Scheduling byIdOrThrowException = this.findByIdOrThrowBadRequestException(schedulingPutDto.getId());
        Scheduling agendamento = schedulingMapper.toScheduling(schedulingPutDto);
        agendamento.setId(byIdOrThrowException.getId());
        this.schedulingRepository.save(agendamento);
    }
    public boolean verificDateOfSchedulling(LocalDate date){
        return schedulingRepository.findByData(date).size() < 4;
    }

    public void updateStatus(SchedulingUpdateStatusDto schedulingUpdateStatusDTO){
        schedulingRepository.updateByStatus(schedulingUpdateStatusDTO.getStatus()
                , schedulingUpdateStatusDTO.getIdScheduling());
    }
}
