package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByPhoneAndEmailIgnoreCase(String phone, String email);
}
