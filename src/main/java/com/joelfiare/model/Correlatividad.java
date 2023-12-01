package com.joelfiare.model;

import jakarta.persistence.*;

@Entity
public class Correlatividad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "materia_id", nullable = true)
    private Integer materiaId;
    @Basic
    @Column(name = "correlativa_id", nullable = true)
    private Integer correlativaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getCorrelativaId() {
        return correlativaId;
    }

    public void setCorrelativaId(Integer correlativaId) {
        this.correlativaId = correlativaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Correlatividad that = (Correlatividad) o;

        if (id != that.id) return false;
        if (materiaId != null ? !materiaId.equals(that.materiaId) : that.materiaId != null) return false;
        if (correlativaId != null ? !correlativaId.equals(that.correlativaId) : that.correlativaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (materiaId != null ? materiaId.hashCode() : 0);
        result = 31 * result + (correlativaId != null ? correlativaId.hashCode() : 0);
        return result;
    }
}
