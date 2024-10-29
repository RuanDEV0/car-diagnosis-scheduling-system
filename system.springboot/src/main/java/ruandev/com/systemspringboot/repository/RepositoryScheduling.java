package ruandev.com.systemspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Scheduling;
public interface RepositoryScheduling extends JpaRepository<Scheduling, Long > {
    Page<Scheduling> findByStatus(String status, Pageable pageable);

}
