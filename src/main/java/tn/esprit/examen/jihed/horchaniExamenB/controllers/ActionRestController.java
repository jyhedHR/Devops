package tn.esprit.examen.jihed.horchaniExamenB.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Action;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Client;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Ordre;
import tn.esprit.examen.jihed.horchaniExamenB.entities.Portfeuille;
import tn.esprit.examen.jihed.horchaniExamenB.services.IActionserv;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Action")
@RestController
public class ActionRestController {
private final IActionserv iActionserv;
    @PostMapping("/addAction")
    public List<Action> add(@RequestBody List<Action> actions){
        return  iActionserv.add(actions);
    }
    @PostMapping("/addPortfeuillewithelement")
    public Portfeuille addPortfeuillewithelement(@RequestBody Portfeuille p){
        return  iActionserv.addprortfruillrWithElements(p);
    }
    @PutMapping("/addPortfeuillewithelement/{symbol}/{referance}")
    public Ordre addordreandafficttoactionandportfeuille(@RequestBody Ordre o, @PathVariable String symbol,@PathVariable Integer referance){
        return  iActionserv.addordreandafficttoactionandportfeuille(o,symbol,referance);
    }

}
