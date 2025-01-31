package tn.esprit.examen.jihed.horchaniExamenB.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity

public class ElementPortfeuille implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idelement;
    String Symbole;
    Integer nbrActions;
    float prixAchat;
    @ManyToOne
    Portfeuille portfeuille;

}
