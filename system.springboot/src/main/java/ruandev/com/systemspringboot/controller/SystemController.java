package ruandev.com.systemspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPostRequestBody;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPutRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePostRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPostRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPutRequestBody;
import ruandev.com.systemspringboot.service.AgendamentoService;
import ruandev.com.systemspringboot.service.ClienteService;
import ruandev.com.systemspringboot.service.ServicoService;
import ruandev.com.systemspringboot.service.VeiculoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("oficina")
public class SystemController {
    private final ClienteService clienteService;
    private final VeiculoService veiculoService;
    private final AgendamentoService agendamentoService;
    private final ServicoService servicoService;


    @GetMapping(path = "/clientes")
    public ResponseEntity<Page<Cliente>> listCliente(Pageable pageable) {
        return ResponseEntity.ok(clienteService.listAll(pageable));
    }

    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> clienteFindById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/veiculos")
    public ResponseEntity<Page<Veiculo>> listVeiculo(Pageable pageable) {
        return ResponseEntity.ok(veiculoService.listAll(pageable));
    }

    @GetMapping(path = "/veiculos/{id}")
    public ResponseEntity<Veiculo> veiculoFindById(@PathVariable long id) {
        return ResponseEntity.ok(veiculoService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/agendamentos")
    public ResponseEntity<Page<Agendamento>> listAgendamento(Pageable pageable) {
        return ResponseEntity.ok(agendamentoService.listAll(pageable));
    }

    @GetMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Agendamento> agendamentoFindById(@PathVariable long id) {
        return ResponseEntity.ok(agendamentoService.findByIdOrThrowException(id));
    }

    @GetMapping(path = "/agendamentos/buscar")
    public ResponseEntity<Page<Agendamento>> listAgendamentoByStatus(@RequestParam String status, Pageable pageable) {
        return ResponseEntity.ok(agendamentoService.listByStatus(status, pageable));
    }
    @GetMapping(path = "/servico")
    public ResponseEntity<Page<Servico>> listServico(Pageable pageable){
        return ResponseEntity.ok(servicoService.listAll(pageable));
    }
    @PostMapping(path = "/cadastro/servico")
    public ResponseEntity<Servico> save(@RequestBody ServicoPostRequestBody servicoPostRequestBody){
        return ResponseEntity.ok(servicoService.save(servicoPostRequestBody));
    }
    @PostMapping(path = "/cadastro/cliente")
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody) {
        return new ResponseEntity<>(clienteService.save(clientePostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastro/veiculo")
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoPostRequestBody veiculoPostRequestBody) {
        return new ResponseEntity<>(veiculoService.save(veiculoPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastro/agendamento")
    public ResponseEntity<Agendamento> save(@RequestBody AgendamentoPostRequestBody agendamentoPostRequestBody) {
        return new ResponseEntity<>(agendamentoService.save(agendamentoPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/cadastro/cliente")
    public ResponseEntity<Void> replace(@RequestBody ClientePutRequestBody clientePutRequestBody) {
        clienteService.replace(clientePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/cadastro/agendamento")
    public ResponseEntity<Void> replace(@RequestBody AgendamentoPutRequestBody agendamentoPutRequestBody) {
        agendamentoService.replace(agendamentoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/cadastro/veiculo")
    public ResponseEntity<Void> replace(@RequestBody VeiculoPutRequestBody veiculoPutRequestBody) {
        veiculoService.replace(veiculoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping(path = "/cadastro/service")
    public ResponseEntity<Void> replace(@RequestBody ServicoPutRequestBody servicoPutRequestBody){
        this.servicoService.replace(servicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/serv")
    public ResponseEntity<Void> deleteServico(@RequestParam long id){
        this.servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(path = "/clientes/{id}")
    public ResponseEntity<Void> deleteCliente(@RequestParam long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/veiculos/{id}")
    public ResponseEntity<Void> deleteVeiculo(@RequestParam long id) {
        veiculoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/agendamentos/{id}")
    public ResponseEntity<Void> deleteAgendamento(@RequestParam long id) {
        agendamentoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
