package tn.esprit.examen.boycott.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.boycott.entities.Produit;
import tn.esprit.examen.boycott.entities.TypeUtilisateur;
import tn.esprit.examen.boycott.entities.Utilisateur;
import tn.esprit.examen.boycott.services.IExempleServices;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("examen")
@RestController
public class ExempleRestController {
    private final IExempleServices services;

    @PostMapping("/ajouterUtilisateur")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return services.ajouterUtilisateur(utilisateur);
    }
    @PostMapping("/ajouterProduitEtCategories")
    public Produit ajouterProduitEtCategories(@RequestBody Produit produit) {
        return services.ajouterProduitEtCategories(produit);
    }
    @PutMapping("/affecterProdAUser/{nomProduit}/{email}")
    public void affecterProdAUser(@PathVariable List<String> nomProduit,
                                  @PathVariable String email) {
        services.affecterProdAUser(nomProduit, email);
    }
    @GetMapping("/chercherProduit/{nomProduit}")
    public boolean chercherProduit(@PathVariable String nomProduit) {

        return services.chercherProduit(nomProduit);
    }

    @GetMapping("/recupererUtilisateurParCriteres/{nomCategorie}/{d}/{tu}")
    public List<Utilisateur> recupererUtilisateurParCriteres(@PathVariable String nomCategorie,
                                                             @PathVariable Date d,
                                                             @PathVariable TypeUtilisateur tu) {
        return services.recupererUtilisateurParCriteres(nomCategorie, d, tu);
    }

    @PutMapping("/desAffecterCatDeProd/{nomCategories}/{nomProduit}")
    public void desAffecterCatDeProd(@PathVariable List<String> nomCategories, @PathVariable String nomProduit) {
        services.desAffecterCatDeProd(nomCategories, nomProduit);
    }
}
