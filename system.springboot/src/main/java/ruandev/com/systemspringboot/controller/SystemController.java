package ruandev.com.systemspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruandev.com.systemspringboot.domain.Agendamento;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.service.AgendamentoService;
import ruandev.com.systemspringboot.service.ClienteService;
import ruandev.com.systemspringboot.service.VeiculoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("cadastro")
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
}
