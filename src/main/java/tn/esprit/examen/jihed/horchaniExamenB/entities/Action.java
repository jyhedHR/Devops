package tn.esprit.examen.jihed.horchaniExamenB.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idAction;

    float prixAchatActuel;
    float prixVentActuel;
    Integer volume;
    LocalDate dateEmission;
    String symbole;
    @OneToMany(mappedBy = "action", fetch = FetchType.EAGER   )
    Set<Ordre> ordres;
}
