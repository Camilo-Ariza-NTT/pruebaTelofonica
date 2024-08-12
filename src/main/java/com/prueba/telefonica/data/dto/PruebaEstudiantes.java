package com.prueba.telefonica.data.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PruebaEstudiantes {

    @Id
    private int edid;
    private String nombre;
    private String especialidad;
    private String grado;
}
