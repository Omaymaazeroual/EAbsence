package com.ensah.core.dao;

import com.ensah.core.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    @Query("SELECT n.idNiveau FROM Niveau n WHERE n.alias =: niveauAlias ")
    Long getNiveauIdByName (@Param("niveauAlias") String niveauAlias);
}
