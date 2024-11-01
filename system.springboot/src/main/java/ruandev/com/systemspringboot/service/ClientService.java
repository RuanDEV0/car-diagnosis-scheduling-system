package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryClient;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final RepositoryClient repositoryClient;
    public Page<Client> listAll(Pageable pageable){
        return repositoryClient.findAll(pageable);
    }
    public Client save(ClientPostRequestBody clientPostRequestBody){
        return repositoryClient.save(SystemMapper.INSTANCE.toClient(clientPostRequestBody));
    }
    public void deleteById(long id){
        repositoryClient.deleteById(id);
    }
    public Client findByIdOrThrowException(Long id){
        return repositoryClient.findById(id).orElseThrow(() -> new RuntimeException("anime not found!"));
    }
    public void replace (ClientPutRequestBody clientPutRequestBody){
        Client savedClient = findByIdOrThrowException(clientPutRequestBody.getId());
        Client client = SystemMapper.INSTANCE.toClient(clientPutRequestBody);
        client.setId(savedClient.getId());
        repositoryClient.save(client);
    }
}
