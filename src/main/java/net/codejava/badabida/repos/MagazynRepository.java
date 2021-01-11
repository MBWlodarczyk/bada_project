package net.codejava.badabida.repos;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Magazyn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface MagazynRepository extends  JpaRepository<Magazyn,Long> {
    List<Magazyn> findAll();

}
