package ruandev.com.systemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;
import ruandev.com.systemspringboot.service.ClientService;
import ruandev.com.systemspringboot.service.ServicoService;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<Service>> findAll(Pageable pegeable){
        return ResponseEntity.ok(servicoService.listAll(pegeable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id){
        return ResponseEntity.ok(servicoService.findByIdOrThrowException(id));
    }

    @PostMapping
    public ResponseEntity<Service> save(@RequestBody ServicePostRequestBody servicePostRequestBody){
        return new ResponseEntity<>(servicoService.save(servicePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ServicePutRequestBody servicePutRequestBody){
        servicoService.replace(servicePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
