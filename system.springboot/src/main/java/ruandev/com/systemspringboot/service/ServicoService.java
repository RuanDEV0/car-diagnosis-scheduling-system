package ruandev.com.systemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.mapper.ServicoMapper;
import ruandev.com.systemspringboot.repository.ServicoRepository;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;
@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ServicoMapper servicoMapper;
    @Transactional(readOnly = true)
    public Page<Servico> listAll(Pageable pageable){
        return this.servicoRepository.findAll(pageable);
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
         this.servicoRepository.deleteById(id);
    }

    public void replace(ServicoPutRequestBody servicoPutRequestBody){
        Servico byIdOrThrowException = this.findByIdOrThrowBadRequestException(servicoPutRequestBody.getId());
        Servico servico = servicoMapper.toServico(servicoPutRequestBody);
        servico.setId(byIdOrThrowException.getId());
    }
}
