package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;
import ruandev.com.systemspringboot.service.ServicoService;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<Servico>> findAll(Pageable pegeable){
        return ResponseEntity.ok(servicoService.listAll(pegeable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        return ResponseEntity.ok(servicoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Servico> save(@Valid @RequestBody ServicoPostRequestBody servicoPostRequestBody){
        return new ResponseEntity<>(servicoService.save(servicoPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ServicoPutRequestBody servicoPutRequestBody){
        servicoService.replace(servicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
