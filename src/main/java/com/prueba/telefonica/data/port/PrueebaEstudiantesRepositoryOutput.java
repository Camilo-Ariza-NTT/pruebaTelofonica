package com.prueba.telefonica.data.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.telefonica.data.dto.PruebaEstudiantes;

public interface PrueebaEstudiantesRepositoryOutput extends JpaRepository<PruebaEstudiantes, Integer> {
    
} 
