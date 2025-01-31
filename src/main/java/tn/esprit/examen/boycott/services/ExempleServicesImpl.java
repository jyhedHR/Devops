package tn.esprit.examen.boycott.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.examen.boycott.entities.*;
import tn.esprit.examen.boycott.repositories.ICategorieRepository;
import tn.esprit.examen.boycott.repositories.IProduitRepository;
import tn.esprit.examen.boycott.repositories.IUtilisateurRepository;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExempleServicesImpl implements IExempleServices {

    private final IUtilisateurRepository utilisateurRepository;
    private final IProduitRepository produitRepository;
    private final ICategorieRepository categorieRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Transactional
    @Override
    public Produit ajouterProduitEtCategories(Produit produit) {
        Set<Categorie> categories = produit.getCategories();
        for(Categorie categorie: categories){
            categorieRepository.save(categorie);
            produit.getCategories().add(categorie);
        }
        return produitRepository.save(produit);
    }

    @Override
    public void affecterProdAUser(List<String> nomProduit, String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        for(String nom : nomProduit){
            Produit produit = produitRepository.findByNomProduit(nom);
            utilisateur.getProduits().add(produit);
        }
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public boolean chercherProduit(String nomProduit) {
        Produit produit = produitRepository.findByNomProduit(nomProduit);
        if(produit==null)
            return false;
        return produit.getEtat() == Etat.BOYCOTT;
    }

    @Override
    public List<Utilisateur> recupererUtilisateurParCriteres(String nomCategorie, Date d, TypeUtilisateur tu) {
        return utilisateurRepository.getUsers(nomCategorie, d, tu);
    }



    @Scheduled(cron = "*/40 * * * * *")
    @Override
    public void afficherEtMettreAJourProduit() {

        List<Utilisateur> users = utilisateurRepository.findByTypeUtilisateur(TypeUtilisateur.ADMIN);
        for(Utilisateur user: users){
            for (Produit p: user.getProduits()){
                p.setEtat(Etat.BOYCOTT);
                produitRepository.save(p);
            }
        }
        log.info("LISTE PRODUITS");
        for (Produit p: produitRepository.findAll())
            log.info(p.toString());

    }

    @Transactional
    @Override
    public void desAffecterCatDeProd(List<String> nomCategories, String nomProduit) {
        Produit produit = produitRepository.findByNomProduit(nomProduit);

        List<Categorie> categoriesToRemove =  new ArrayList<>();

        for(Categorie categorie:produit.getCategories()){
            if(nomCategories.contains(categorie.getNomCategorie())){
               categoriesToRemove.add(categorie);
            }
        }
        produit.getCategories().removeAll(categoriesToRemove);
        produitRepository.save(produit);
    }
}
