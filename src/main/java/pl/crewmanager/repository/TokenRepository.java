package pl.crewmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.crewmanager.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByName(String name);
}
