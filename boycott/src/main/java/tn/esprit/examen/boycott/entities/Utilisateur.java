package tn.esprit.examen.boycott.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String email;
    Date dateInscrit;
    @Enumerated(EnumType.STRING)
    TypeUtilisateur typeUtilisateur;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    Set<Produit> produits;
}
