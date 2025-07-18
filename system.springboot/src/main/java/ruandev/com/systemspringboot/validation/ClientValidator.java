package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.dto.client.ClientPostDto;
import ruandev.com.systemspringboot.dto.client.ClientPutDto;
import ruandev.com.systemspringboot.repository.ClientRepository;

@RequiredArgsConstructor
@Component
public class ClientValidator {
    private final ClientRepository clientRepository;

    public boolean validate(ClientPostDto client) {
        return clientRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }
    public boolean validate(ClientPutDto client){
        return clientRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }

}
