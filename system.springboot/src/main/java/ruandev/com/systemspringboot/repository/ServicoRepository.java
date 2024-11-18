package ruandev.com.systemspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Override
    Page<Servico> findAll(Pageable pageable);
}
