package tn.esprit.examen.boycott.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.examen.boycott.entities.Categorie;

public interface ICategorieRepository extends CrudRepository<Categorie, Long> {
}
