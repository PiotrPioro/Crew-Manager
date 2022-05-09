package pl.crewmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.crewmanager.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Worker findByEmail(String email);

    @Query("select w from Worker w where w.id = ?1")
    Worker findWorkerById(Long id);
}
