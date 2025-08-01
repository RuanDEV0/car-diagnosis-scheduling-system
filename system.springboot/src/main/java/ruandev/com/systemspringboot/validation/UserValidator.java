package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.dto.user.UserPutDto;
import ruandev.com.systemspringboot.repository.ClientRepository;

@RequiredArgsConstructor
@Component
public class ClientValidator {
    private final ClientRepository clientRepository;

    public boolean validate(UserPostDto client) {
        return clientRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }
    public boolean validate(UserPutDto client){
        return clientRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }

}
