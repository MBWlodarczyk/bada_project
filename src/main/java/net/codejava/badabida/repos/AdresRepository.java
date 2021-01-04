package net.codejava.badabida.repos;

import net.codejava.badabida.model.Adres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface AdresRepository extends CrudRepository<Adres,Long> {
    public Set<Adres> findAll();
}
