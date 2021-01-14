package net.codejava.badabida.repos;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Czesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CzescRepository extends JpaRepository<Czesc, Long> {
    Czesc findCzescByNrCzesci(Long nrCzesci);
}
