package com.prueba.telefonica.bussines.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.telefonica.bussines.dto.PruebaEstudiantesBussines;
import com.prueba.telefonica.bussines.port.CrudEstudianteInput;
import com.prueba.telefonica.bussines.port.CrudEstudianteOutput;

@Component
public class PrueebaEstudiantesBussinessAdapter implements CrudEstudianteInput {

    @Autowired
    private CrudEstudianteOutput crudEstudianteOutput;

    @Override
    public void llamarCreatEstudiante(PruebaEstudiantesBussines estudiante) {
        crudEstudianteOutput.creatEstudiante(estudiante);
    }

    @Override
    public List<PruebaEstudiantesBussines> llamarBuscarEstudiante() {
        return crudEstudianteOutput.buscarEstudiante();
    }

    @Override
    public void llamarActualizarEstudiante(PruebaEstudiantesBussines estudiante) {
        crudEstudianteOutput.actualizarEstudiante(estudiante);
    }

    @Override
    public void llamarEliminarEstudiante(PruebaEstudiantesBussines estudiante) {
        crudEstudianteOutput.eliminarEstudiante(estudiante);
    }

}
