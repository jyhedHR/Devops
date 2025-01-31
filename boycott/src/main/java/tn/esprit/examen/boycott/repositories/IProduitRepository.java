package tn.esprit.examen.boycott.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.examen.boycott.entities.Produit;

public interface IProduitRepository extends CrudRepository<Produit, Long> {

    Produit findByNomProduit(String  nomProduit);
}
