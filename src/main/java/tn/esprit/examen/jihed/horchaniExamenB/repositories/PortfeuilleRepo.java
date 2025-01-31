package tn.esprit.examen.jihed.horchaniExamenB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Action;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Portfeuille;

public interface PortfeuilleRepo extends JpaRepository<Portfeuille, Long> {
    Portfeuille findByReference(Integer r);
}
