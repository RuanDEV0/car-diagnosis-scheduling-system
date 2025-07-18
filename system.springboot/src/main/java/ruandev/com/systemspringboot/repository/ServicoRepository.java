package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    boolean existsByName(String name);
}
