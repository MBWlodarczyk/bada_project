package net.codejava.badabida.repos;

import net.codejava.badabida.model.Hurtownia;
import net.codejava.badabida.model.Magazyn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface MagazynRepository extends JpaRepository<Magazyn, Long> {
    List<Magazyn> findAll();
    Optional<Magazyn> findByNrMagazynu(Long nrMagazynu);


}
