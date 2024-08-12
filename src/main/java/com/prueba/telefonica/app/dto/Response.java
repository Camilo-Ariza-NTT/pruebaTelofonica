package com.prueba.telefonica.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private List<Request> estudiantes;
    private String estatus;
}
