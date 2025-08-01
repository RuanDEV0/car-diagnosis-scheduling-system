package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.User;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.dto.user.UserPutDto;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ClientMapper;
import ruandev.com.systemspringboot.repository.ClientRepository;
import ruandev.com.systemspringboot.validation.ClientValidator;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Transactional
    public User save(UserPostDto userPostDto){
        if(clientValidator.validate(userPostDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        String passwordEncoded = passwordEncoder.encode(userPostDto.getPassword());
        userPostDto.setPassword(passwordEncoded);
        return clientRepository.save(clientMapper.toClient(userPostDto));
    }
    public void deleteById(long id){
        clientRepository.deleteById(this.findByIdOrThrowBadRequestException(id).getId());
    }
    public User findByIdOrThrowBadRequestException(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BadRequestException("client not found!"));
    }
    public void replace (UserPutDto userPutDto){
        User savedUser = this.findByIdOrThrowBadRequestException(userPutDto.getId());
        if(clientValidator.validate(userPutDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        User user = clientMapper.toClient(userPutDto);
        user.setId(savedUser.getId());
        clientRepository.save(user);
    }
}
