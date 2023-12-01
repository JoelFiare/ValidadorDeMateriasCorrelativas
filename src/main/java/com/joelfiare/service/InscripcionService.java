package com.joelfiare.service;

import com.joelfiare.model.Correlatividad;
import com.joelfiare.model.Inscripcion;

import java.util.List;

public class InscripcionService {
    public boolean estaAprobada(Inscripcion inscripcion, List<Correlatividad> correlatividadesCursadas) {
        return inscripcion.aprobada(correlatividadesCursadas);
    }
}