package tn.esprit.examen.jihed.horchaniExamenB.entities;

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
public class Portfeuille implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idportfeille;

    Integer reference;
    float solde;
    @OneToMany(mappedBy = "portfeuille", fetch = FetchType.EAGER   )
    Set<ElementPortfeuille> elementPortfeuilles;
    @OneToMany(mappedBy = "portfeuille", fetch = FetchType.EAGER   )
    Set<Ordre> ordres;

}
