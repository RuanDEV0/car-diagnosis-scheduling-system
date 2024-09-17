package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}
