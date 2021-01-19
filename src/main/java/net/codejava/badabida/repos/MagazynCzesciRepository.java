package net.codejava.badabida.repos;

import net.codejava.badabida.model.MagazynyCzesci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagazynCzesciRepository extends JpaRepository<MagazynyCzesci, Long> {
    List<MagazynyCzesci> findAll();
}
