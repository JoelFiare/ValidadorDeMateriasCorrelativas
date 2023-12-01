package com.joelfiare.test;

import com.joelfiare.dao.MateriaDAO;
import com.joelfiare.model.Materia;

public class MateriaTest {

    public static void main(String[] args) {
        // Crear un MateriaDAO para interactuar con la base de datos
        MateriaDAO materiaDAO = new MateriaDAO();

        // Agregar materias de prueba
        Materia materia1 = new Materia();
        materia1.setNombre("Materia 1");

        Materia materia2 = new Materia();
        materia2.setNombre("Materia 2");

        // Agregar materias a la base de datos
        materiaDAO.agregarMateria(materia1);
        materiaDAO.agregarMateria(materia2);

        // Obtener todas las materias y mostrarlas en la consola
        System.out.println("Todas las materias:");
        materiaDAO.obtenerTodasLasMaterias().forEach(materia -> System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre()));

        // Obtener una materia por su ID y mostrarla en la consola
        int materiaId = 1;
        Materia materiaDesdeBD = materiaDAO.obtenerMateriaPorId(materiaId);
        if (materiaDesdeBD != null) {
            System.out.println("\nMateria encontrada:");
            System.out.println("ID: " + materiaDesdeBD.getId() + ", Nombre: " + materiaDesdeBD.getNombre());
        } else {
            System.out.println("\nMateria no encontrada con ID: " + materiaId);
        }

        // Cerrar el EntityManagerFactory al finalizar
        materiaDAO.cerrarEntityManagerFactory();
    }
}
