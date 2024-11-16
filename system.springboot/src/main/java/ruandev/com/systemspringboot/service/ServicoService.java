package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.mapper.ServiceMapper;
import ruandev.com.systemspringboot.repository.ServiceRepository;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServicoService {
    private final ServiceRepository serviceRepository;
    @Autowired
    private ServiceMapper serviceMapper;
    @Transactional(readOnly = true)
    public Page<Service> listAll(Pageable pageable){
        return this.serviceRepository.findAll(pageable);
    }
    @Transactional
    public Service save(ServicePostRequestBody servicePostRequestBody){
        return this.serviceRepository.save(serviceMapper.toService(servicePostRequestBody));
    }

    public Service findByIdOrThrowException(Long id){
        return this.serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public void deleteById(Long id){
         this.serviceRepository.deleteById(id);
    }

    public void replace(ServicePutRequestBody servicePutRequestBody){
        Service byIdOrThrowException = this.findByIdOrThrowException(servicePutRequestBody.getId());
        Service servico = serviceMapper.toService(servicePutRequestBody);
        servico.setId(byIdOrThrowException.getId());
    }
}
