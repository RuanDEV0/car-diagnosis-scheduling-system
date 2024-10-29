package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Client;

public interface RepositoryClient extends JpaRepository<Client, Long> {
}
