package com.prueba.telefonica.data.adpter;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.telefonica.bussines.dto.PruebaEstudiantesBussines;
import com.prueba.telefonica.bussines.port.CrudEstudianteOutput;
import com.prueba.telefonica.data.dto.PruebaEstudiantes;
import com.prueba.telefonica.data.port.PrueebaEstudiantesRepositoryOutput;

@Service
public class PruebaEstudianteDataAdapter implements CrudEstudianteOutput {

    @Autowired
    private PrueebaEstudiantesRepositoryOutput prueebaEstudiantesRepositoryOutput;

    @Override
    public void creatEstudiante(PruebaEstudiantesBussines estudiante) {
        prueebaEstudiantesRepositoryOutput.save(setPruebaEstudiantes(estudiante));
    }

    @Override
    public List<PruebaEstudiantesBussines> buscarEstudiante() {
        return setListPruebaEstudiantes(prueebaEstudiantesRepositoryOutput.findAll());
    }

    @Override
    public void actualizarEstudiante(PruebaEstudiantesBussines estudiante) {
        prueebaEstudiantesRepositoryOutput.save(setPruebaEstudiantes(estudiante));
    }

    @Override
    public void eliminarEstudiante(PruebaEstudiantesBussines estudiante) {
        prueebaEstudiantesRepositoryOutput.delete(setPruebaEstudiantes(estudiante));
    }

    public PruebaEstudiantes setPruebaEstudiantes(PruebaEstudiantesBussines estudiante) {
        PruebaEstudiantes pruebaEstudiantes = new PruebaEstudiantes();
        pruebaEstudiantes.setEdid(estudiante.getEdid());
        pruebaEstudiantes.setNombre(estudiante.getNombre());
        pruebaEstudiantes.setEspecialidad(estudiante.getEspecialidad());
        pruebaEstudiantes.setGrado(estudiante.getGrado());

        return pruebaEstudiantes;
    }

    public List<PruebaEstudiantesBussines> setListPruebaEstudiantes(List<PruebaEstudiantes> estudiantes) {
        List<PruebaEstudiantesBussines> estudiantesBussines = new ArrayList<>();

        for (PruebaEstudiantes estudiante : estudiantes) {
            PruebaEstudiantesBussines estudianteBussines = new PruebaEstudiantesBussines();
            estudianteBussines.setEdid(estudiante.getEdid());
            estudianteBussines.setNombre(estudiante.getNombre());
            estudianteBussines.setEspecialidad(estudiante.getEspecialidad());
            estudianteBussines.setGrado(estudiante.getGrado());
            estudiantesBussines.add(estudianteBussines);
        }
        return estudiantesBussines;
    }

}
