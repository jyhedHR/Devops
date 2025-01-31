package tn.esprit.examen.jihed.horchaniExamenB.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity

public class Ordre implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idOrdre;
    LocalDate datecreation;
    LocalDate Dateexuction;
    Integer Volume;
    float montant;
    @Enumerated(EnumType.STRING)
    Statut statut;
    @Enumerated(EnumType.STRING)
    Type TypeOrdre;
    @ManyToOne
    Portfeuille portfeuille;
    @ManyToOne
    Action action;
}
