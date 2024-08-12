package com.prueba.telefonica.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Request {
    private int edid;
    private String nombre;
    private String especialidad;
    private String grado;
}
