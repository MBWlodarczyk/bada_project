package net.codejava.badabida.repos;

import net.codejava.badabida.model.Hurtownia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HurtowniaRepository extends JpaRepository<Hurtownia, Long> {
    Optional<Hurtownia> findByNrHurtowni(Long nrHurtowni);

}
