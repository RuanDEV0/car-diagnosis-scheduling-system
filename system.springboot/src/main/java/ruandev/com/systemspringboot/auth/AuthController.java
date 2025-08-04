package ruandev.com.systemspringboot.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ruandev.com.systemspringboot.dto.RecoveryJwtTokenDto;
import ruandev.com.systemspringboot.dto.user.LoginUserDto;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.service.UserService;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> login(@RequestBody LoginUserDto loginUserDto) {
        return new ResponseEntity<>(userService.login(loginUserDto), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserPostDto userPostDto) {
        userService.save(userPostDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
