package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.dto.client.ClientPostDto;
import ruandev.com.systemspringboot.dto.client.ClientPutDto;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ClientMapper;
import ruandev.com.systemspringboot.repository.ClientRepository;
import ruandev.com.systemspringboot.validation.ClientValidator;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;

    @Transactional
    public Client save(ClientPostDto clientPostDto){
        if(clientValidator.validate(clientPostDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        return clientRepository.save(clientMapper.toClient(clientPostDto));
    }
    public void deleteById(long id){
        clientRepository.deleteById(this.findByIdOrThrowBadRequestException(id).getId());
    }
    public Client findByIdOrThrowBadRequestException(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BadRequestException("client not found!"));
    }
    public void replace (ClientPutDto clientPutDto){
        Client savedClient = this.findByIdOrThrowBadRequestException(clientPutDto.getId());
        if(clientValidator.validate(clientPutDto)){
            throw new BadRequestException("Client with phone or email registered");
        }
        Client client = clientMapper.toClient(clientPutDto);
        client.setId(savedClient.getId());
        clientRepository.save(client);
    }
}
