package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Cliente;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryCliente;
import ruandev.com.systemspringboot.request.cliente.ClientePostRequestBody;
import ruandev.com.systemspringboot.request.cliente.ClientePutRequestBody;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final RepositoryCliente repositoryCliente;
    public Page<Cliente> listAll(Pageable pageable){
        return repositoryCliente.findAll(pageable);
    }
    public Cliente save(ClientePostRequestBody clientePostRequestBody){
        return repositoryCliente.save(SystemMapper.INSTANCE.toCliente(clientePostRequestBody));
    }
    public void deleteById(long id){
        repositoryCliente.deleteById(id);
    }
    public Cliente findByIdOrThrowException(Long id){
        return repositoryCliente.findById(id).orElseThrow(() -> new RuntimeException("anime not found!"));
    }
    public void replace (ClientePutRequestBody clientePutRequestBody){
        Cliente savedCliente = findByIdOrThrowException(clientePutRequestBody.getId());
        Cliente cliente = SystemMapper.INSTANCE.toCliente(clientePutRequestBody);
        cliente.setId(savedCliente.getId());
        repositoryCliente.save(cliente);
    }
}
