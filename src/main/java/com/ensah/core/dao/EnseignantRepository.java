package com.ensah.core.dao;

import com.ensah.core.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
