package com.ensah.core.services.impl;

import com.ensah.core.bo.*;
import com.ensah.core.bo.Module;
import com.ensah.core.dao.*;
import com.ensah.core.dto.CoordinationDTO;
import com.ensah.core.services.StructurePedagogiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructurePedagogiqueServiceImpl implements StructurePedagogiqueService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private NiveauRepository niveauRepository;

    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private CoordinationRepository coordinationRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;


    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }
    @Override
    public List<Matiere> getAllMatieres() { return matiereRepository.findAll();  }
    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }
    @Override
    public List<Coordination> getAllCoordinations() {
        return coordinationRepository.findAll();
    }



    @Override
    public void creerMatiere(String nom, String code, Long moduleId) {
        Matiere matiere = new Matiere();
        matiere.setNom(nom);
        matiere.setCode(code);
        Module module = moduleRepository.findById(moduleId).orElse(null);

        if (module != null) {
            matiere.setModule(module);
            matiereRepository.save(matiere);
        } else {
            // Gérer le cas où l'ID du module n'est pas valide
            throw new IllegalArgumentException("ID de module invalide");
        }
    }



    @Override
    public void updateMatiere(Matiere newmatiere) {
        Matiere matiere = matiereRepository.findById(newmatiere.getIdMatiere() ).get();
        matiere.setNom(newmatiere.getNom());
        matiere.setCode(newmatiere.getCode());
        matiere.setModule(newmatiere.getModule());
        matiereRepository.save(matiere);

    }


    @Override
    public void deleteMatiere(Matiere matiere) {
        matiereRepository.delete(matiere);
    }


    // CRUD Module
    @Override
    public void creerModule(Module newModule) {
        Module module = new Module();
        module.setTitre(newModule.getTitre());
        module.setCode(newModule.getCode());
        module.setNiveau(newModule.getNiveau());
        moduleRepository.save(module);
    }
    @Override
    public void updateModule(Module newModule) {
        Module module = moduleRepository.findById(newModule.getIdModule()).get();
        module.setCode(newModule.getCode());
        module.setTitre(newModule.getTitre());
        module.setNiveau(newModule.getNiveau());
        moduleRepository.save(module);
    }

    @Override
    public void deleteModule(Module module) {
        moduleRepository.delete(module);
    }

    // CRUD niveau
    @Override
    public void updateNiveau(Niveau newNiveau) {
        Niveau niveau = niveauRepository.findById(newNiveau.getIdNiveau()).get();
        niveau.setAlias(newNiveau.getAlias());
        niveau.setTitre(newNiveau.getTitre());
        niveau.setFiliere(newNiveau.getFiliere());
        niveauRepository.save(niveau);

    }

    @Override
    public void deleteNiveau(Niveau niveau) {
        niveauRepository.delete(niveau);
    }

    // CRUD fililere
    @Override
    public void creerNiveau(Niveau newNiveau) {
        Niveau niveau = new Niveau();
        niveau.setAlias(newNiveau.getAlias());
        niveau.setTitre(newNiveau.getTitre());
        niveau.setFiliere(newNiveau.getFiliere());
        niveauRepository.save(niveau);
    }
    @Override
    public void updateFiliere(Filiere newFiliere) {
        Filiere filiere = filiereRepository.findById(newFiliere.getIdFiliere()).get();
        filiere.setTitreFiliere(newFiliere.getTitreFiliere());
        filiere.setAnneeaccreditation(newFiliere.getAnneeaccreditation());
        filiere.setAnneeFinaccreditation(newFiliere.getAnneeFinaccreditation());
        filiereRepository.save(filiere);

    }
    @Override
    public void deleteFiliere(Filiere filiere) {
        filiereRepository.delete(filiere);
    }


    @Override
    public void creerFiliere(Filiere newFiliere) {
        Filiere filiere = new Filiere();
        filiere.setTitreFiliere(newFiliere.getTitreFiliere());
        filiere.setCodeFiliere(newFiliere.getCodeFiliere());
        filiere.setAnneeaccreditation(newFiliere.getAnneeaccreditation());
        filiere.setAnneeFinaccreditation(newFiliere.getAnneeFinaccreditation());
        filiereRepository.save(filiere);
    }


    @Override
    public void creerCoordination(CoordinationDTO coordinationDTO) {
        Coordination coordination = new Coordination();
        coordination.setDateDebut(coordinationDTO.getDateDebut());
        coordination.setDateFin(coordinationDTO.getDateFin());
        Enseignant coordinateur = enseignantRepository.findById(coordinationDTO.getIdCoordonateur()).orElse(null);
        Filiere filiere = filiereRepository.findById(coordinationDTO.getIdFiliere()).orElse(null);

        coordination.setCoordonateur(coordinateur);
        coordination.setFiliere(filiere);

        coordinationRepository.save(coordination);
    }

    @Override
    public void updateCoordination(Coordination newCoordination) {
        Coordination coordination = coordinationRepository.findById(newCoordination.getIdCoordination()).get();
        coordination.setDateDebut(newCoordination.getDateDebut());
        coordination.setDateFin(newCoordination.getDateFin());
        coordination.setCoordonateur(newCoordination.getCoordonateur());
        coordination.setFiliere(newCoordination.getFiliere());
        coordinationRepository.save(coordination);

    }


    @Override
    public void deleteCoordination(Coordination coordination) {
        coordinationRepository.delete(coordination);
    }
    
    @Override
    public Optional<Matiere> getMatiereById(Long matiereId){return matiereRepository.findById(matiereId);}

    @Override
    public Module getModuleById(Long moduleId) {
        return moduleRepository.findById(moduleId).orElse(null);
    }

    @Override
    public Niveau getNiveauById(Long niveauId) {
        return niveauRepository.findById(niveauId).orElse(null);
    }

    @Override
    public Filiere getFiliereById(Long filiereId) {
        return filiereRepository.findById(filiereId).orElse(null);
    }
    @Override
    public Coordination getCoordinationById(Long coordinationId){return coordinationRepository.findById(coordinationId).orElse(null);}
    @Override
    public Long getNiveauIdByName(@Param("niveauAlias") String niveauAlias){ return niveauRepository.getNiveauIdByName(niveauAlias);}

}
