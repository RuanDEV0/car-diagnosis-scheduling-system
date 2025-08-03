package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.dto.service.ServicoPostDto;
import ruandev.com.systemspringboot.dto.service.ServicoPutDto;
import ruandev.com.systemspringboot.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServicoService servicoService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok(servicoService.listAll());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.findByIdOrThrowBadRequestException(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Servico> save(@Valid @RequestBody ServicoPostDto servicoPostDto) {
        return new ResponseEntity<>(servicoService.save(servicoPostDto), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ServicoPutDto servicoPutDto) {
        servicoService.replace(servicoPutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
