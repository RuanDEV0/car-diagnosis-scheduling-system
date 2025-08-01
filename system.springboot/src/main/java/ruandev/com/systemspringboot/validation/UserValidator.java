package ruandev.com.systemspringboot.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.dto.user.UserPutDto;
import ruandev.com.systemspringboot.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserValidator {
    private final UserRepository userRepository;

    public boolean validate(UserPostDto client) {
        return userRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }
    public boolean validate(UserPutDto client){
        return userRepository.existsByPhoneAndEmailIgnoreCase(client.getPhone(), client.getEmail());
    }

}
