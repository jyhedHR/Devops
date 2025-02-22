package tn.esprit.examen.jihed.horchaniExamenB.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.jihed.horchaniExamenB.entities.*;
import tn.esprit.examen.jihed.horchaniExamenB.repositories.ActionRepo;
import tn.esprit.examen.jihed.horchaniExamenB.repositories.ElementPrepo;
import tn.esprit.examen.jihed.horchaniExamenB.repositories.OrdreRepo;
import tn.esprit.examen.jihed.horchaniExamenB.repositories.PortfeuilleRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service

public class actionservices implements IActionserv {
    private final ActionRepo actionRepo;
    private final ElementPrepo elementPrepo;
    private final PortfeuilleRepo portfeuilleRepo;
    private  final OrdreRepo ordreRepo;

    @Override
    public List<Action> add(List<Action> actions) {
        return actionRepo.saveAll(actions);
    }

    @Override
    public Portfeuille addprortfruillrWithElements(Portfeuille portfeuille) {
        Set<ElementPortfeuille> elementPortfeuille = portfeuille.getElementPortfeuilles();
        elementPrepo.saveAll(elementPortfeuille);
        for (ElementPortfeuille e : elementPortfeuille) {
           e.setPortfeuille(portfeuille);

        }
        return portfeuilleRepo.save(portfeuille);
    }

    @Override
    public Ordre addordreandafficttoactionandportfeuille(Ordre ordre, String symbole, Integer referance) {
        Action action=actionRepo.findActionBySymbole(symbole);
        Portfeuille portfeuille=portfeuilleRepo.findByReference(referance);
        if(ordre.getTypeOrdre() == Type.ACHAT){
            Float PA=action.getPrixAchatActuel();
            ordre.setMontant(PA*ordre.getVolume());
        }else{
            ordre.setMontant(action.getPrixVentActuel()*ordre.getVolume());
        }
        action.getOrdres().add(ordre);
        portfeuille.getOrdres().add(ordre);

        ordre.setStatut(Statut.EN_ATTENT);
        ordre.setDatecreation(LocalDate.now());


        return ordreRepo.save(ordre);
    }





}
