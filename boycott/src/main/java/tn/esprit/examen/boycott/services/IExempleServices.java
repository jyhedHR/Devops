package tn.esprit.examen.boycott.services;

import tn.esprit.examen.boycott.entities.Produit;
import tn.esprit.examen.boycott.entities.TypeUtilisateur;
import tn.esprit.examen.boycott.entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IExempleServices {

    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    Produit ajouterProduitEtCategories(Produit produit);

    void affecterProdAUser(List<String> nomProduit, String email);

    boolean chercherProduit(String nomProduit);

    List<Utilisateur> recupererUtilisateurParCriteres(String nomCategorie, Date d, TypeUtilisateur tu);
    void afficherEtMettreAJourProduit();
    void desAffecterCatDeProd(List<String> nomCategories, String nomProuit);
}
