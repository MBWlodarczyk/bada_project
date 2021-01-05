package net.codejava.badabida.repos;

import net.codejava.badabida.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Long> {

    Optional<Pracownik> findByUsername(String username);

}
