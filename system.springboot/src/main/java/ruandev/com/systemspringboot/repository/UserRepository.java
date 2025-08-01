package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneAndEmailIgnoreCase(String phone, String email);
}
