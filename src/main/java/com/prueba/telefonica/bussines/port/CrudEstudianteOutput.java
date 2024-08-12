package com.prueba.telefonica.bussines.port;

import java.util.List;

import com.prueba.telefonica.bussines.dto.PruebaEstudiantesBussines;

public interface CrudEstudianteOutput {
    public void creatEstudiante(PruebaEstudiantesBussines estudiante);

    public List<PruebaEstudiantesBussines> buscarEstudiante();

    public void actualizarEstudiante(PruebaEstudiantesBussines estudiante);

    public void eliminarEstudiante(PruebaEstudiantesBussines estudiante);
}
