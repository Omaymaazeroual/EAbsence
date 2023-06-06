package com.ensah.core.dto;

import java.util.Set;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Niveau;

public class FiliereDTO {

    private Long idFiliere;
    private String titreFiliere;
    private String codeFiliere;
    private int anneeaccreditation;
    private int anneeFinaccreditation;
    private Set<Niveau> niveaux;
    private Coordination periodeCoordination;
    private Long idCoordinateur;

    public void setIdCoordinateur(Long idCoordinateur) {
        this.idCoordinateur = idCoordinateur;
    }

    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getTitreFiliere() {
        return titreFiliere;
    }

    public void setTitreFiliere(String titreFiliere) {
        this.titreFiliere = titreFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public int getAnneeaccreditation() {
        return anneeaccreditation;
    }

    public void setAnneeaccreditation(int anneeaccreditation) {
        this.anneeaccreditation = anneeaccreditation;
    }

    public int getAnneeFinaccreditation() {
        return anneeFinaccreditation;
    }

    public void setAnneeFinaccreditation(int anneeFinaccreditation) {
        this.anneeFinaccreditation = anneeFinaccreditation;
    }

    public Set<Niveau> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(Set<Niveau> niveaux) {
        this.niveaux = niveaux;
    }

    public Coordination getPeriodeCoordination() {
        return periodeCoordination;
    }

    public Long getIdCoordinateur() {
        if (periodeCoordination != null && periodeCoordination.getCoordonateur() != null) {
            return periodeCoordination.getCoordonateur().getIdUtilisateur();
        }
        return null;
    }

    public void setPeriodeCoordination(Coordination periodeCoordination) {
        this.periodeCoordination = periodeCoordination;
    }
}
