package net.codejava.badabida.repos;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.CzesciZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CzesciZamowieniaRepository extends JpaRepository<CzesciZamowienia, Long> {
}
