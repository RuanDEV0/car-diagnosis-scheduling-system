package ruandev.com.systemspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.util.StatusType;

import java.time.LocalDate;
import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long > {
    Page<Scheduling> findByStatus(StatusType status, Pageable pageable);

    List<Scheduling> findByData(LocalDate date);
    @Query(nativeQuery = true, value = """

            UPDATE tb_sheduling SET status = :statusType WHERE id = :idScheduling""")
    Void updateByStatus(StatusType statusType, Long idScheduling);
}
