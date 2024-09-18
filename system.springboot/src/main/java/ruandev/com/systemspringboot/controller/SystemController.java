package ruandev.com.systemspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.request.agendamento.AgendamentoPostRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePostRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPostRequestBody;
import ruandev.com.systemspringboot.service.AgendamentoService;
import ruandev.com.systemspringboot.service.ClienteService;
import ruandev.com.systemspringboot.service.VeiculoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("oficina")
public class SystemController {
    private final ClienteService clienteService;
    private final VeiculoService veiculoService;
    private final AgendamentoService agendamentoService;

    @GetMapping(path = "/clientes")
    public ResponseEntity<Page<Cliente>> listCliente(Pageable pageable) {
        return ResponseEntity.ok(clienteService.listAll(pageable));
    }

    @GetMapping(path = "/veiculos")
    public ResponseEntity<Page<Veiculo>> listVeiculo(Pageable pageable) {
        return ResponseEntity.ok(veiculoService.listAll(pageable));
    }

    @GetMapping(path = "/agendamentos")
    public ResponseEntity<Page<Agendamento>> listAgendamento(Pageable pageable) {
        return ResponseEntity.ok(agendamentoService.listAll(pageable));
    }
    @PostMapping(path = "/cadastro/cliente")
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody){
        return new ResponseEntity<>(clienteService.save(clientePostRequestBody), HttpStatus.CREATED);
    }
    @PostMapping(path = "/cadastro/veiculo")
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoPostRequestBody veiculoPostRequestBody){
        return new ResponseEntity<>(veiculoService.save(veiculoPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastro/agendamento")
    public ResponseEntity<Agendamento> save(@RequestBody AgendamentoPostRequestBody agendamentoPostRequestBody){
        return new ResponseEntity<>(agendamentoService.save(agendamentoPostRequestBody), HttpStatus.CREATED);
    }
}
