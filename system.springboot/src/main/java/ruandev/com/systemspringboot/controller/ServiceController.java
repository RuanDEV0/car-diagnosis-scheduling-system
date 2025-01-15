package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.dto.service.ServicoPostDto;
import ruandev.com.systemspringboot.dto.service.ServicoPutDto;
import ruandev.com.systemspringboot.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll( ){
        return ResponseEntity.ok(servicoService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        return ResponseEntity.ok(servicoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Servico> save(@Valid @RequestBody ServicoPostDto servicoPostDto){
        return new ResponseEntity<>(servicoService.save(servicoPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ServicoPutDto servicoPutDto){
        servicoService.replace(servicoPutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
