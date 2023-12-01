package com.joelfiare.test;
import com.joelfiare.dao.AlumnoDAO;
import com.joelfiare.model.Alumno;
import java.util.List;

public class AlumnoTest {

    public static void main(String[] args) {
        // Crear un AlumnoDAO para interactuar con la base de datos
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        // Crear un nuevo alumno
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre("Juan");
        nuevoAlumno.setApellido("Pérez");

        // Agregar el nuevo alumno a la base de datos
        alumnoDAO.agregarAlumno(nuevoAlumno);

        // Obtener un alumno por ID
        int alumnoId = 1;
        Alumno alumnoObtenido = alumnoDAO.obtenerAlumnoPorId(alumnoId);
        if (alumnoObtenido != null) {
            System.out.println("Nombre del alumno: " + alumnoObtenido.getNombre());
            System.out.println("Apellido del alumno: " + alumnoObtenido.getApellido());
        } else {
            System.out.println("No se encontró ningún alumno con el ID proporcionado.");
        }

        // Obtener todos los alumnos
        List<Alumno> listaAlumnos = alumnoDAO.obtenerTodosLosAlumnos();
        System.out.println("Lista de alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido());
        }

        // Cerrar el EntityManagerFactory al finalizar
        alumnoDAO.cerrarEntityManagerFactory();
    }
}
