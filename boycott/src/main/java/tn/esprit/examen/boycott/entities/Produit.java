package tn.esprit.examen.boycott.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String nomProduit;
    @Enumerated(EnumType.STRING)
    Etat etat;
    @ToString.Exclude
    @ManyToMany(cascade =CascadeType.PERSIST)
    Set<Categorie> categories;
}
