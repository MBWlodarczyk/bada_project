package net.codejava.badabida.repos;

import net.codejava.badabida.model.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZamowieniaRepository extends JpaRepository<Zamowienie, Long> {
    List<Zamowienie> findAll();
    Optional<Zamowienie> findByNrZamowienia(Long id);
}
