package tn.esprit.examen.jihed.horchaniExamenB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Action;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Client;

public interface ActionRepo extends JpaRepository<Action, Long> {
    Action findActionBySymbole(String symbole);
}
