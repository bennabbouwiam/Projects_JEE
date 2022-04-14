package ma.jpa.hospital.repositories;

import ma.jpa.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByNom(String name);
}
