package com.ensah.core.dto;

public class ModuleDTO {

        private String titre;
        private String code;
        private Long niveau;

        // Constructeurs, getters et setters

        public ModuleDTO() {
            // Constructeur par défaut
        }

        public ModuleDTO(String titre, String code, Long idNiveau) {
            this.titre = titre;
            this.code = code;
            this.niveau = idNiveau;
        }

        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    public Long getNiveau() {
        return niveau;
    }

    public void setNiveau(Long niveau) {
        this.niveau = niveau;
    }


}
