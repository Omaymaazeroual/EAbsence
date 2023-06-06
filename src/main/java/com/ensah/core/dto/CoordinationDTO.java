package com.ensah.core.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CoordinationDTO {
    private Long idCoordination;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private Long idCoordonateur;
    private Long idFiliere;

    // Constructeurs, getters et setters

    public Long getIdCoordination() {
        return idCoordination;
    }

    public void setIdCoordination(Long idCoordination) {
        this.idCoordination = idCoordination;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Long getIdCoordonateur() {
        return idCoordonateur;
    }

    public void setIdCoordonateur(Long idCoordonateur) {
        this.idCoordonateur = idCoordonateur;
    }

    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }
}
