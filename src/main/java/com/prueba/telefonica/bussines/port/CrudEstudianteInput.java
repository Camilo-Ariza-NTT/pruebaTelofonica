package com.prueba.telefonica.bussines.port;

import java.util.List;

import com.prueba.telefonica.bussines.dto.PruebaEstudiantesBussines;

public interface CrudEstudianteInput {
    public void llamarCreatEstudiante(PruebaEstudiantesBussines estudiante);

    public List<PruebaEstudiantesBussines> llamarBuscarEstudiante();

    public void llamarActualizarEstudiante(PruebaEstudiantesBussines estudiante);

    public void llamarEliminarEstudiante(PruebaEstudiantesBussines estudiante);
}
