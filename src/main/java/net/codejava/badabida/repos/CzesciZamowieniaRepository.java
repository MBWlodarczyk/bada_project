package net.codejava.badabida.repos;

import net.codejava.badabida.model.CzesciZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CzesciZamowieniaRepository extends JpaRepository<CzesciZamowienia, Long> {
}
