package ruandev.com.systemspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ruandev.com.systemspringboot.domain.Veiculo;
import ruandev.com.systemspringboot.mapper.SystemMapper;
import ruandev.com.systemspringboot.repository.RepositoryVeiculo;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPostRequestBody;
import ruandev.com.systemspringboot.request.veiculo.VeiculoPutRequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final RepositoryVeiculo repositoryVeiculo;

    public Page<Veiculo> listAll(Pageable pageable){
        return repositoryVeiculo.findAll(pageable);
    }
    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody){
        return repositoryVeiculo.save(SystemMapper.INSTANCE.toVeiculo(veiculoPostRequestBody));
    }
    public void deleteById(long id){
        repositoryVeiculo.deleteById(id);
    }
    public Veiculo findByIdOrThrowException(Long id){
        return repositoryVeiculo.findById(id).orElseThrow(() -> new RuntimeException("anime not found!"));
    }
    public void replace(VeiculoPutRequestBody veiculoPutRequestBody){
        Veiculo savedVeiculo = findByIdOrThrowException(veiculoPutRequestBody.getId());
        Veiculo veiculo = SystemMapper.INSTANCE.toVeiculo(veiculoPutRequestBody);
        veiculo.setId(savedVeiculo.getId());
        repositoryVeiculo.save(veiculo);
    }
}
