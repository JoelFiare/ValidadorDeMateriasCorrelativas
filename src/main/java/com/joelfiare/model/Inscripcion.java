package com.joelfiare.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Inscripcion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "alumno_id", nullable = true)
    private Integer alumnoId;
    @Basic
    @Column(name = "materia_id", nullable = true)
    private Integer materiaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscripcion that = (Inscripcion) o;

        if (id != that.id) return false;
        if (alumnoId != null ? !alumnoId.equals(that.alumnoId) : that.alumnoId != null) return false;
        if (materiaId != null ? !materiaId.equals(that.materiaId) : that.materiaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (alumnoId != null ? alumnoId.hashCode() : 0);
        result = 31 * result + (materiaId != null ? materiaId.hashCode() : 0);
        return result;
    }

    public boolean aprobada(List<Correlatividad> correlatividadesCursadas) {
        for (Correlatividad correlatividad : correlatividadesCursadas) {
            if (correlatividad.getMateriaId() == this.getMateriaId()) {
                return true;
            }
        }
        return false;
    }
}
