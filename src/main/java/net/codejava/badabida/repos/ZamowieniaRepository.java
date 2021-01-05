package net.codejava.badabida.repos;

import net.codejava.badabida.model.Zamowienie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ZamowieniaRepository extends CrudRepository<Zamowienie, Long> {
    Set<Zamowienie> findAll();
}
