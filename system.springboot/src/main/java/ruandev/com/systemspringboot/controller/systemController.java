package ruandev.com.systemspringboot.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamento")
public class systemController {
    @GetMapping
    public ResponseEntity<Void> list(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
