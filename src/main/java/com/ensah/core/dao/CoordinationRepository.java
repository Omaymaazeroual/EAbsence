package com.ensah.core.dao;

import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoordinationRepository extends JpaRepository<Coordination, Long> {
    @Query("SELECT C.coordonateur FROM Coordination C ")
    List<Enseignant> getAllCoordinateurs ();

    @Query("SELECT C FROM Coordination C WHERE C.coordonateur.idUtilisateur = :idCoordinateur")
    Coordination getCoordinationByIdCoordinateur(@Param("idCoordinateur") Long idCoordinateur);


}
