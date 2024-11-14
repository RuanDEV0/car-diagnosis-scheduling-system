package ruandev.com.systemspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Override
    Page<Service> findAll(Pageable pageable);
}
