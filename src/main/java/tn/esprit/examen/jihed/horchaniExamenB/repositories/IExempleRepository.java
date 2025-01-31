package tn.esprit.examen.jihed.horchaniExamenB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Client;

public interface IExempleRepository extends JpaRepository<Client, Long> {
}