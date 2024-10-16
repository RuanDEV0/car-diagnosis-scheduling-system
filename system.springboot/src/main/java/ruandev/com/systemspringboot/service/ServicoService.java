package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Servico;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryService;
import ruandev.com.systemspringboot.request.service.ServicoPostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicoPutRequestBody;

@Service
@RequiredArgsConstructor
public class ServicoService {
    private final RepositoryService repositoryService;
    public Page<Servico> listAll(Pageable pageable){
        return this.repositoryService.findAll(pageable);
    }
    public Servico save(ServicoPostRequestBody servicoPostRequestBody){
        return this.repositoryService.save(SystemMapper.INSTANCE.toServico(servicoPostRequestBody));
    }

    public Servico findByIdOrThrowException(Long id){
        return this.repositoryService.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public void delete(Long id){
         this.repositoryService.deleteById(id);
    }

    public void replace(ServicoPutRequestBody servicoPutRequestBody){
        Servico byIdOrThrowException = this.findByIdOrThrowException(servicoPutRequestBody.getId());
        Servico servico = SystemMapper.INSTANCE.toServico(servicoPutRequestBody);
        servico.setId(byIdOrThrowException.getId());
    }
}
