package com.ensah.core.dto;

public class NiveauDTO {

    private String titre;
    private String alias;
    private Long filiereId;

    // Constructeurs, getters et setters

    public NiveauDTO() {   }

    public NiveauDTO(String titre, String alias, Long filiereId) {
        this.titre = titre;
        this.alias = alias;
        this.filiereId = filiereId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }
}
