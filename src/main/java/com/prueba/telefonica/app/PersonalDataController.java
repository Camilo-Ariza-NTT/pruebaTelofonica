package com.prueba.telefonica.app;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.telefonica.app.dto.Request;
import com.prueba.telefonica.app.dto.Response;
import com.prueba.telefonica.bussines.dto.PruebaEstudiantesBussines;
import com.prueba.telefonica.bussines.port.CrudEstudianteInput;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PersonalDataController {

    @Autowired
    private CrudEstudianteInput crudEstudianteInput;
    private ResponseEntity responseEntity;
    private Response response;

    @PostMapping("/crear")
    public ResponseEntity<Response> crear(@RequestBody Request request) {
        response = new Response();

        crudEstudianteInput.llamarCreatEstudiante(setPruebaEstudiantesBussines(request));

        response.setEstatus("Estudiante creado correctamente");
        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/leer")
    public ResponseEntity<Response> leer() {
        response = new Response();
        List<PruebaEstudiantesBussines> listaPruebaEstudiantesBussines = crudEstudianteInput.llamarBuscarEstudiante();
        setListaPruebaEstudiantesBussines(listaPruebaEstudiantesBussines);

        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Response> actualizar(@RequestBody Request request) {
        response = new Response();

        crudEstudianteInput.llamarActualizarEstudiante(setPruebaEstudiantesBussines(request));
        response.setEstatus("Estudiante actulizado correctamente");
        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Response> eliminar(@RequestBody Request request) {
        response = new Response();
        
        crudEstudianteInput.llamarEliminarEstudiante(setPruebaEstudiantesBussines(request));
        response.setEstatus("Estudiante fue eliminado correctamente");
        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    public PruebaEstudiantesBussines setPruebaEstudiantesBussines(Request request) {
        PruebaEstudiantesBussines pruebaEstudiantesBussines = new PruebaEstudiantesBussines();

        pruebaEstudiantesBussines.setEdid(request.getEdid());
        pruebaEstudiantesBussines.setNombre(request.getNombre());
        pruebaEstudiantesBussines.setEspecialidad(request.getEspecialidad());
        pruebaEstudiantesBussines.setGrado(request.getGrado());
        return pruebaEstudiantesBussines;
    }

    public void setListaPruebaEstudiantesBussines(List<PruebaEstudiantesBussines> listaPruebaEstudiantesBussines) {
        List<Request> requestLista = new ArrayList<>();

        for (PruebaEstudiantesBussines pruebaEstudiantesBussines : listaPruebaEstudiantesBussines) {
            Request request = new Request();
            request.setEdid(pruebaEstudiantesBussines.getEdid());
            request.setNombre(pruebaEstudiantesBussines.getNombre());
            request.setEspecialidad(pruebaEstudiantesBussines.getEspecialidad());
            request.setGrado(pruebaEstudiantesBussines.getGrado());
            requestLista.add(request);
        }

        response.setEstudiantes(requestLista);

    }
}
