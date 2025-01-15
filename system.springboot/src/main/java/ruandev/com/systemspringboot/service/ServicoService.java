package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ServicoMapper;
import ruandev.com.systemspringboot.repository.ServicoRepository;
import ruandev.com.systemspringboot.dto.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.dto.service.ServicoPutRequestBody;

import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ServicoMapper servicoMapper;
    @Transactional(readOnly = true)
    public List<Servico> listAll(){
        return this.servicoRepository.findAll();
    }
    @Transactional
    public Servico save(ServicoPostRequestBody servicoPostRequestBody){
        return this.servicoRepository.save(servicoMapper.toServico(servicoPostRequestBody));
    }

    public Servico findByIdOrThrowBadRequestException(Long id){
        return this.servicoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Service not found"));
    }

    public void deleteById(Long id){
        this.servicoRepository.deleteById(findByIdOrThrowBadRequestException(id).getId());
    }

    public void replace(ServicoPutRequestBody servicoPutRequestBody){
        Servico byIdOrThrowException = this.findByIdOrThrowBadRequestException(servicoPutRequestBody.getId());
        Servico servico = servicoMapper.toServico(servicoPutRequestBody);
        servico.setId(byIdOrThrowException.getId());
        servicoRepository.save(servico);
    }
}
