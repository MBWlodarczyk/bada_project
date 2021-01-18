package net.codejava.badabida.repos;

import net.codejava.badabida.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Long> {
    Optional<Pracownik> findByUsername(String username);

    Optional<Pracownik> findByNrPracownika(Long nrPracownika);

    List<Pracownik> findAllByStanowisko(String stanowisko);

}
