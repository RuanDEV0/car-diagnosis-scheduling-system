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
import ruandev.com.systemspringboot.mapper.UserMapper;
import ruandev.com.systemspringboot.repository.UserRepository;
import ruandev.com.systemspringboot.validation.UserValidator;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Transactional
    public User save(UserPostDto userPostDto){
        if(userValidator.validate(userPostDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        String passwordEncoded = passwordEncoder.encode(userPostDto.getPassword());
        userPostDto.setPassword(passwordEncoded);
        return userRepository.save(userMapper.toClient(userPostDto));
    }
    public void deleteById(long id){
        userRepository.deleteById(this.findByIdOrThrowBadRequestException(id).getId());
    }
    public User findByIdOrThrowBadRequestException(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("client not found!"));
    }
    public void replace (UserPutDto userPutDto){
        User savedUser = this.findByIdOrThrowBadRequestException(userPutDto.getId());
        if(userValidator.validate(userPutDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        User user = userMapper.toClient(userPutDto);
        user.setId(savedUser.getId());
        userRepository.save(user);
    }
}
