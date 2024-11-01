package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryService;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServico {
    private final RepositoryService repositoryService;
    public Page<Service> listAll(Pageable pageable){
        return this.repositoryService.findAll(pageable);
    }
    public Service save(ServicePostRequestBody servicePostRequestBody){
        return this.repositoryService.save(SystemMapper.INSTANCE.toService(servicePostRequestBody));
    }

    public Service findByIdOrThrowException(Long id){
        return this.repositoryService.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public void deleteById(Long id){
         this.repositoryService.deleteById(id);
    }

    public void replace(ServicePutRequestBody servicePutRequestBody){
        Service byIdOrThrowException = this.findByIdOrThrowException(servicePutRequestBody.getId());
        Service servico = SystemMapper.INSTANCE.toService(servicePutRequestBody);
        servico.setId(byIdOrThrowException.getId());
    }
}
