package ruandev.com.systemspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;
import ruandev.com.systemspringboot.service.SchedulingService;
import ruandev.com.systemspringboot.service.ClientService;
import ruandev.com.systemspringboot.service.ServicoService;
import ruandev.com.systemspringboot.service.VehicleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("oficina")
public class SystemController {
    private final ClientService clientService;
    private final VehicleService vehicleService;
    private final SchedulingService schedulingService;
    private final ServicoService servicoService;


    @GetMapping(path = "/clientes")
    public ResponseEntity<Page<Client>> listCliente(Pageable pageable) {
        return ResponseEntity.ok(clientService.listAll(pageable));
    }

    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<Client> clienteFindById(@PathVariable long id) {
        return ResponseEntity.ok(clientService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/veiculos")
    public ResponseEntity<Page<Vehicle>> listVeiculo(Pageable pageable) {
        return ResponseEntity.ok(vehicleService.listAll(pageable));
    }

    @GetMapping(path = "/veiculos/{id}")
    public ResponseEntity<Vehicle> veiculoFindById(@PathVariable long id) {
        return ResponseEntity.ok(vehicleService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/agendamentos")
    public ResponseEntity<Page<Scheduling>> listAgendamento(Pageable pageable) {
        return ResponseEntity.ok(schedulingService.listAll(pageable));
    }

    @GetMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Scheduling> agendamentoFindById(@PathVariable long id) {
        return ResponseEntity.ok(schedulingService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/agendamentos/buscar")
    public ResponseEntity<Page<Scheduling>> listAgendamentoByStatus(@RequestParam String status, Pageable pageable) {
        return ResponseEntity.ok(schedulingService.listByStatus(status, pageable));
    }
    @GetMapping(path = "/servico")
    public ResponseEntity<Page<Service>> listServico(Pageable pageable){
        return ResponseEntity.ok(servicoService.listAll(pageable));
    }
    @GetMapping(path = "/servico/{id}")
    public ResponseEntity<Service> servicoFindById(@PathVariable long id){
        return ResponseEntity.ok(servicoService.findByIdOrThrowException(id));
    }
    @PostMapping(path = "/cadastro/servico")
    public ResponseEntity<Service> save(@RequestBody ServicePostRequestBody servicePostRequestBody){
        return ResponseEntity.ok(servicoService.save(servicePostRequestBody));
    }
    @PostMapping(path = "/cadastro/cliente")
    public ResponseEntity<Client> save(@RequestBody ClientPostRequestBody clientPostRequestBody) {
        return new ResponseEntity<>(clientService.save(clientPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastro/veiculo")
    public ResponseEntity<Vehicle> save(@RequestBody VehiclePostRequestBody vehiclePostRequestBody) {
        return new ResponseEntity<>(vehicleService.save(vehiclePostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastro/agendamento")
    public ResponseEntity<Scheduling> save(@RequestBody SchedulingPostRequestBody schedulingPostRequestBody) {
        return new ResponseEntity<>(schedulingService.save(schedulingPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/cadastro/cliente")
    public ResponseEntity<Void> replace(@RequestBody ClientPutRequestBody clientPutRequestBody) {
        clientService.replace(clientPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/cadastro/agendamento")
    public ResponseEntity<Void> replace(@RequestBody SchedulingPutRequestBody schedulingPutRequestBody) {
        schedulingService.replace(schedulingPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/cadastro/veiculo")
    public ResponseEntity<Void> replace(@RequestBody VehiclePutRequestBody vehiclePutRequestBody) {
        vehicleService.replace(vehiclePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping(path = "/cadastro/service")
    public ResponseEntity<Void> replace(@RequestBody ServicePutRequestBody servicePutRequestBody){
        this.servicoService.replace(servicePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/servico/{id}")
    public ResponseEntity<Void> deleteServico(@RequestParam long id){
        this.servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(path = "/clientes")
    public ResponseEntity<Void> deleteCliente(@RequestParam long id) {
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/veiculos/{id}")
    public ResponseEntity<Void> deleteVeiculo(@RequestParam long id) {
        vehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Void> deleteAgendamento(@RequestParam long id) {
        schedulingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
