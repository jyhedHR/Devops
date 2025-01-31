package tn.esprit.examen.jihed.horchaniExamenB.services;

import tn.esprit.examen.jihed.horchaniExamenB.entities.Action;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Ordre;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Portfeuille;

import java.util.List;

public interface IActionserv  {
    List<Action> add(List<Action> actions);
    Portfeuille addprortfruillrWithElements(Portfeuille portfeuille);
    Ordre addordreandafficttoactionandportfeuille(Ordre ordre , String symbole,Integer referance);
}
