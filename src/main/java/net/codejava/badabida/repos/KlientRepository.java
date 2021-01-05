package net.codejava.badabida.repos;

import net.codejava.badabida.model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {

    Optional<Klient> findByUsername(String username);


}