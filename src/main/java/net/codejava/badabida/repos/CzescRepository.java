package net.codejava.badabida.repos;

import net.codejava.badabida.model.Czesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CzescRepository extends JpaRepository<Czesc, Long> {
    Czesc findCzescByNrCzesci(Long nrCzesci);
}
