package com.ensah.core.services;

import com.ensah.core.bo.*;
import com.ensah.core.bo.Module;
import com.ensah.core.dto.CoordinationDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StructurePedagogiqueService {

    List<Module> getAllModules();
    List<Niveau> getAllNiveaux();
    List<Filiere> getAllFilieres();
    List<Matiere> getAllMatieres();
    List<Enseignant> getAllEnseignants();
    public List<Coordination> getAllCoordinations();

    void creerMatiere(String nom, String code, Long moduleId);
    void updateMatiere(Matiere matiere);

    void deleteMatiere(Matiere matiere);
    void updateModule(Module module);
    void deleteModule(Module module);
    void creerModule(Module module);
    void updateNiveau(Niveau niveau);
    void deleteNiveau(Niveau niveau);
    void creerNiveau(Niveau niveau);
    void updateFiliere(Filiere filiere);
    void deleteFiliere(Filiere filiere);
    void creerFiliere(Filiere filiere);
    void updateCoordination(Coordination newCoordination);
    void deleteCoordination(Coordination coordination);
    public Optional<Matiere> getMatiereById(Long matiereId);
    public Module getModuleById(Long moduleId);
    public Niveau getNiveauById(Long niveauId);
    public Filiere getFiliereById(Long filiereId);
    public Coordination getCoordinationById(Long coordinationId);
    public Long getNiveauIdByName (@Param("niveauAlias") String niveauAlias);
    void creerCoordination(CoordinationDTO coordinationDTO);

}
