package tn.esprit.examen.boycott.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.examen.boycott.entities.TypeUtilisateur;
import tn.esprit.examen.boycott.entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IUtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);
    @Query("select  u from Utilisateur  u " +
            "join  u.produits prod " +
            "join prod.categories cat " +
            "where u.dateInscrit > :dateI " +
            "and u.typeUtilisateur =:tu " +
            "and cat.nomCategorie =:nom")
    List<Utilisateur> getUsers(@Param("nom") String nomCategorie, @Param("dateI") Date d, @Param("tu") TypeUtilisateur tu);

    List<Utilisateur> findByTypeUtilisateur(TypeUtilisateur typeUtilisateur);

}
