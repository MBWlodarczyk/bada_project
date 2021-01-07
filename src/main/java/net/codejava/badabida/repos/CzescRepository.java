package net.codejava.badabida.repos;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Czesc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CzescRepository extends CrudRepository<Czesc, Long> {
    Set<Czesc> findAll();

}
