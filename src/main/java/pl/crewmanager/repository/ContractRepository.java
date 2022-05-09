package pl.crewmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.crewmanager.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("select c from Contract c where c.id = ?1")
    Contract findContractById(Long id);
}
