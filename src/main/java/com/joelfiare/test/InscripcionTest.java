package com.joelfiare.test;

import com.joelfiare.dao.InscripcionDAO;
import com.joelfiare.model.Inscripcion;

import java.util.List;

public class InscripcionTest {

    public static void main(String[] args) {
        // Crear un InscripcionDAO para interactuar con la base de datos
        InscripcionDAO inscripcionDAO = new InscripcionDAO();

        // Agregar una inscripción de prueba
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumnoId(1); // ID de alumno existente en la base de datos
        inscripcion.setMateriaId(1); // ID de materia existente en la base de datos

        // Agregar la inscripción a la base de datos
        inscripcionDAO.agregarInscripcion(inscripcion);

        // Obtener una inscripción por su ID y mostrarla en la consola
        int inscripcionId = 1;
        Inscripcion inscripcionDesdeBD = inscripcionDAO.obtenerInscripcionPorId(inscripcionId);
        if (inscripcionDesdeBD != null) {
            System.out.println("\nInscripción encontrada:");
            System.out.println("ID: " + inscripcionDesdeBD.getId() + ", Alumno ID: " + inscripcionDesdeBD.getAlumnoId() + ", Materia ID: " + inscripcionDesdeBD.getMateriaId());
        } else {
            System.out.println("\nInscripción no encontrada con ID: " + inscripcionId);
        }

        // Mostrar todas las inscripciones en la consola
        System.out.println("Todas las inscripciones:");
        List<Inscripcion> inscripciones = inscripcionDAO.obtenerTodasLasInscripciones();
        for (Inscripcion insc : inscripciones) {
            System.out.println("ID: " + insc.getId() + ", Alumno ID: " + insc.getAlumnoId() + ", Materia ID: " + insc.getMateriaId());
        }

        // Cerrar el EntityManagerFactory al finalizar
        inscripcionDAO.cerrarEntityManagerFactory();
    }
}