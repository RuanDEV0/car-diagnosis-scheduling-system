package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.dto.client.ClientPostDto;
import ruandev.com.systemspringboot.dto.client.ClientPutDto;
import ruandev.com.systemspringboot.service.ClientService;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Client> save(@Valid @RequestBody ClientPostDto clientPostDto){
        return new ResponseEntity<>(clientService.save(clientPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClientPutDto clientPutDto){
        clientService.replace(clientPutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
