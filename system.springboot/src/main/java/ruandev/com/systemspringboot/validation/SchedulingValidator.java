package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.dto.scheduling.SchedulingPostDto;
import ruandev.com.systemspringboot.repository.SchedulingRepository;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class SchedulingValidator {
    private final SchedulingRepository schedulingRepository;

    public boolean validate(SchedulingPostDto scheduling) {


        return true;
    }

    public boolean validateDate(LocalDate date){
        return schedulingRepository.findByData(date).size() <= 4;
    }
}
