package com.ensah.core.web.controllers;

import com.ensah.core.bo.*;
import com.ensah.core.bo.Module;
import com.ensah.core.dto.*;
import com.ensah.core.services.StructurePedagogiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/structure-pedagogique")
public class StructurePedagogiqueController {

    @Autowired
    private StructurePedagogiqueService structurePedagogiqueService;

    @GetMapping("")
    public String afficherStructurePedagogique(Model model) {
        // Récupérer les modules, niveaux et filières à partir de la base de données
        List<Matiere> matieres = structurePedagogiqueService.getAllMatieres();
        List<Module> modules = structurePedagogiqueService.getAllModules();
        List<Niveau> niveaux = structurePedagogiqueService.getAllNiveaux();
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();

        // Ajouter les listes au modèle pour les rendre accessibles dans la vue
        model.addAttribute("matieres", matieres);
        model.addAttribute("modules", modules);
        model.addAttribute("niveaux", niveaux);
        model.addAttribute("filieres", filieres);

        return "cadreadmin/structure-pedagogique";
    }

    // Gestion des matieres
    @GetMapping("/matiere/creer")
    public String afficherFormulaireCreationMatiere(Model model) {
        List<Module> modules = structurePedagogiqueService.getAllModules();
        model.addAttribute("modules", modules);
        model.addAttribute("matiereDTO", new MatiereDTO());
        return "cadreadmin/formulaire-creation-matiere";
    }

    @PostMapping("/matiere/creer")
    public String creerMatiere(@ModelAttribute("matiereDTO")MatiereDTO matiereDTO) {
        Long IdModule = matiereDTO.getIdModule();
        structurePedagogiqueService.creerMatiere(matiereDTO.getNom(), matiereDTO.getCode(), IdModule);
        return "redirect:/structure-pedagogique";
    }


    @GetMapping("/afficher-matiere")
    public String afficherMatiere(Model model) {
        List<Matiere> matieres = structurePedagogiqueService.getAllMatieres();
        model.addAttribute("matieres", matieres);
        return "cadreadmin/afficher-matiere";
    }


    @GetMapping("/modifier-matiere/{id}")
    public String showModifierMatiere(@PathVariable Long id, Model model) {
        Matiere matiere = structurePedagogiqueService.getMatiereById(id).get();
        model.addAttribute("matiere", matiere);
        List<Module> modules = structurePedagogiqueService.getAllModules();
        model.addAttribute("modules", modules);
        return "cadreadmin/formulaire-modification-matiere";
    }


    @PostMapping("/modifier-matiere/{id}")
    public String modifierMatiere(@ModelAttribute("matiere") Matiere matiere) {
        structurePedagogiqueService.updateMatiere(matiere);
        return "redirect:/structure-pedagogique/afficher-matiere";
    }

    @GetMapping("/supprimer-matiere/{id}")
    public String supprimerMatiere(@PathVariable("id") Long id) {
        Matiere matiere = structurePedagogiqueService.getMatiereById(id).get();
        structurePedagogiqueService.deleteMatiere(matiere);
        return "redirect:/structure-pedagogique/afficher-matiere";
    }

    // Gestion des modules


    @GetMapping("/modules/creer")
    public String afficherFormulaireCreationModule(Model model) {
        // Code pour afficher le formulaire de création d'un module
        List<Niveau> niveaux = structurePedagogiqueService.getAllNiveaux();
        model.addAttribute("niveaux", niveaux);
        model.addAttribute("moduleDTO", new Module()); // Ajout de l'objet ModuleDTO à Model
        return "cadreadmin/formulaire-creation-module";
    }

    @PostMapping("/modules/creer")
    public String creerModule(@ModelAttribute("moduleDTO") Module moduleDTO) {
        //Long idNiveau = moduleDTO.getNiveau();
        structurePedagogiqueService.creerModule(moduleDTO);
        return "redirect:/structure-pedagogique";
    }
    @GetMapping("/afficher-module")
    public String afficherModule(Model model) {
        List<Module> modules = structurePedagogiqueService.getAllModules();
        model.addAttribute("modules", modules);
        return "cadreadmin/afficher-module";
    }
    @GetMapping("/modifier-module/{id}")
    public String showModifierModule(@PathVariable Long id, Model model) {
        Module module = structurePedagogiqueService.getModuleById(id);
        model.addAttribute("module", module);
        List<Niveau> niveaux = structurePedagogiqueService.getAllNiveaux();
        model.addAttribute("niveaux", niveaux);
        return "cadreadmin/formulaire-modification-module";
    }


    @PostMapping("/modifier-module/{id}")
    public String modifierModule(@ModelAttribute("module") Module module) {
        System.out.println(module.getIdModule());
        structurePedagogiqueService.updateModule(module);
        return "redirect:/structure-pedagogique/afficher-module";
    }

    @GetMapping("/supprimer-module/{id}")
    public String supprimerModule(@PathVariable("id") Long id) {
        Module module = structurePedagogiqueService.getModuleById(id);
        structurePedagogiqueService.deleteModule(module);
        return "redirect:/structure-pedagogique/afficher-module";
    }


    // Gestion des niveaux

    @GetMapping("/niveaux/creer")
    public String afficherFormulaireCreationNiveau(Model model) {
        // Code pour afficher le formulaire de création d'un niveau
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        model.addAttribute("niveauDTO", new Niveau()); // Ajout de l'objet ModuleDTO à Model
        return "cadreadmin/formulaire-creation-niveau";
    }

    @PostMapping("/niveaux/creer")
    public String creerNiveau(@ModelAttribute("niveauDTO") Niveau niveauDTO) {

        structurePedagogiqueService.creerNiveau(niveauDTO);
        return "redirect:/structure-pedagogique";
    }

    @GetMapping("/afficher-niveau")
    public String afficherNiveau(Model model) {
        List<Niveau> niveaux = structurePedagogiqueService.getAllNiveaux();
        model.addAttribute("niveaux", niveaux);
        return "cadreadmin/afficher-niveau";
    }
    @GetMapping("/modifier-niveau/{id}")
    public String showModifierNiveau(@PathVariable Long id, Model model) {
        Niveau niveau = structurePedagogiqueService.getNiveauById(id);
        model.addAttribute("niveau", niveau);
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        return "cadreadmin/formulaire-modification-niveau";
    }


    @PostMapping("/modifier-niveau/{id}")
    public String modifierNiveau(@ModelAttribute("niveau") Niveau niveau) {

        structurePedagogiqueService.updateNiveau(niveau);
        return "redirect:/structure-pedagogique/afficher-niveau";
    }

    @GetMapping("/supprimer-niveau/{id}")
    public String supprimerNiveau(@PathVariable("id") Long id) {
        Niveau niveau = structurePedagogiqueService.getNiveauById(id);
        structurePedagogiqueService.deleteNiveau(niveau);
        return "redirect:/structure-pedagogique/afficher-niveau";
    }

    // Gestion des filières

    @GetMapping("/filieres/creer")
    public String afficherFormulaireCreationFiliere(Model model) {
        model.addAttribute("filiereDTO", new Filiere());
        return "cadreadmin/formulaire-creation-filiere";
    }
    @PostMapping("/filieres/creer")
    public String creerFiliere(@ModelAttribute("filiereDTO") Filiere filiereDTO) {
        structurePedagogiqueService.creerFiliere(filiereDTO);
        return "redirect:/structure-pedagogique";
    }

    @GetMapping("/afficher-filiere")
    public String afficherFiliere(Model model) {
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        return "cadreadmin/afficher-filiere";
    }
    @GetMapping("/modifier-filiere/{id}")
    public String showModifierFiliere(@PathVariable Long id, Model model) {
        Filiere filiere = structurePedagogiqueService.getFiliereById(id);
        model.addAttribute("filiere", filiere);
        return "cadreadmin/formulaire-modification-filiere";
    }

    @PostMapping("/modifier-filiere/{id}")
    public String modifierFiliere(@ModelAttribute("filiere") Filiere filiere) {
        structurePedagogiqueService.updateFiliere(filiere);
        return "redirect:/structure-pedagogique/afficher-filiere";
    }
    @GetMapping("/supprimer-filiere/{id}")
    public String supprimerFiliere(@PathVariable("id") Long id) {
        Filiere filiere = structurePedagogiqueService.getFiliereById(id);
        structurePedagogiqueService.deleteFiliere(filiere);
        return "redirect:/structure-pedagogique/afficher-filiere";
    }

    // Affecter un coordinateur a une filiere
    @GetMapping("/coordinateurs/creer")
    public String afficherFormulaireCreationCoordination(Model model) {
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();
        List<Enseignant> enseignants = structurePedagogiqueService.getAllEnseignants();
        model.addAttribute("filieres", filieres);
        model.addAttribute("enseignants", enseignants);
        model.addAttribute("coordinationDTO", new CoordinationDTO());
        return "cadreadmin/formulaire-creation-coordination";
    }

    @PostMapping("/coordinateurs/creer")
    public String creerCoordination(@ModelAttribute("coordinationDTO")CoordinationDTO coordinationDTO) {
        Long IdFiliere = coordinationDTO.getIdFiliere();
        Long IdEnseignant = coordinationDTO.getIdCoordination();
        structurePedagogiqueService.creerCoordination(coordinationDTO);
        return "redirect:/structure-pedagogique";
    }
    @GetMapping("/afficher-coordination")
    public String afficherCoordination(Model model) {
        List<Coordination> coordinations = structurePedagogiqueService.getAllCoordinations();
        model.addAttribute("coordinations", coordinations);
        return "cadreadmin/afficher-coordination";
    }
    @GetMapping("/modifier-coordination/{id}")
    public String showModifierCoordination(@PathVariable Long id, Model model) {
        Niveau niveau = structurePedagogiqueService.getNiveauById(id);
        Coordination coordination = structurePedagogiqueService.getCoordinationById(id);
        model.addAttribute("coordination", coordination);
        List<Filiere> filieres = structurePedagogiqueService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        List<Enseignant> enseignants= structurePedagogiqueService.getAllEnseignants();
        model.addAttribute("enseignants", enseignants);
        return "cadreadmin/formulaire-modification-coordination";
    }


    @PostMapping("/modifier-coordination/{id}")
    public String modifierCoordination(@ModelAttribute("coordination") Coordination coordination) {
        System.out.println(coordination.getIdCoordination());
        System.out.println(coordination.getCoordonateur().getIdUtilisateur());
        System.out.println(coordination.getFiliere().getIdFiliere());
        structurePedagogiqueService.updateCoordination(coordination);
        return "redirect:/structure-pedagogique/afficher-coordination";
    }

    @GetMapping("/supprimer-coordination/{id}")
    public String supprimerCoordination(@PathVariable("id") Long id) {
        Coordination coordination = structurePedagogiqueService.getCoordinationById(id);
        structurePedagogiqueService.deleteCoordination(coordination);
        return "redirect:/structure-pedagogique/afficher-coordination";
    }

}
