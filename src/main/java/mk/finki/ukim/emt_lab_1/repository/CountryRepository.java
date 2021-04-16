package mk.finki.ukim.emt_lab_1.repository;

import mk.finki.ukim.emt_lab_1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
