package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.User;
import ruandev.com.systemspringboot.dto.RecoveryJwtTokenDto;
import ruandev.com.systemspringboot.dto.user.LoginUserDto;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.dto.user.UserPutDto;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.UserMapper;
import ruandev.com.systemspringboot.repository.UserRepository;
import ruandev.com.systemspringboot.security.SecurityConfiguration;
import ruandev.com.systemspringboot.util.UserDetailsImpl;
import ruandev.com.systemspringboot.validation.UserValidator;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto login(LoginUserDto loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());
        Authentication authenticate =
                authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }
    @Transactional
    public User save(UserPostDto userPostDto){
        if(userValidator.validate(userPostDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        userPostDto.setPassword(securityConfiguration.passwordEncoder().encode(userPostDto.getPassword()));
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
