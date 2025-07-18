package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.repository.ServicoRepository;

@Component
@RequiredArgsConstructor
public class ServicoValidator {
    private final ServicoRepository repository;

    public boolean validateByName(String name){
        return repository.existsByName(name);
    }

}
