package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.dto.service.ServicoPostDto;
import ruandev.com.systemspringboot.dto.service.ServicoPutDto;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ServicoMapper;
import ruandev.com.systemspringboot.repository.ServicoRepository;

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
    public Servico save(ServicoPostDto servicoPostDto){
        return this.servicoRepository.save(servicoMapper.toServico(servicoPostDto));
    }

    public Servico findByIdOrThrowBadRequestException(Long id){
        return this.servicoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Service not found"));
    }

    public void deleteById(Long id){
        this.servicoRepository.deleteById(findByIdOrThrowBadRequestException(id).getId());
    }

    public void replace(ServicoPutDto servicoPutDto){
        Servico byIdOrThrowException = this.findByIdOrThrowBadRequestException(servicoPutDto.getId());
        Servico servico = servicoMapper.toServico(servicoPutDto);
        servico.setId(byIdOrThrowException.getId());
        servicoRepository.save(servico);
    }
}
