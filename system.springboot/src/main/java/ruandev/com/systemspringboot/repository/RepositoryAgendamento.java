package ruandev.com.systemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruandev.com.systemspringboot.domain.Agendamento;
public interface RepositoryAgendamento extends JpaRepository<Agendamento, Long > {
}
