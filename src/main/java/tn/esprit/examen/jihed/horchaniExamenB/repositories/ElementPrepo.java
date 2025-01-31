package tn.esprit.examen.jihed.horchaniExamenB.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Action;
import tn.esprit.examen.jihed.horchaniExamenB.entities.ElementPortfeuille;

public interface ElementPrepo extends JpaRepository<ElementPortfeuille, Long> {
}
