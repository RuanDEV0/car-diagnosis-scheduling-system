package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ClientMapper;
import ruandev.com.systemspringboot.repository.ClientRepository;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Transactional
    public Client save(ClientPostRequestBody clientPostRequestBody){
        return clientRepository.save(clientMapper.toClient(clientPostRequestBody));
    }
    public void deleteById(long id){
        clientRepository.deleteById(this.findByIdOrThrowBadRequestException(id).getId());
    }
    public Client findByIdOrThrowBadRequestException(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BadRequestException("client not found!"));
    }
    public void replace (ClientPutRequestBody clientPutRequestBody){
        Client savedClient = findByIdOrThrowBadRequestException(clientPutRequestBody.getId());
        Client client = clientMapper.toClient(clientPutRequestBody);
        client.setId(savedClient.getId());
        clientRepository.save(client);
    }
}
