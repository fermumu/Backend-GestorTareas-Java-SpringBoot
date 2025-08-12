package com.example.TaskGestor.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String descripcion;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String prioridad;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String fechLimite;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String categoria;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private Boolean isCompleted;

    public TaskModel() {
    }

    public TaskModel(Long id, String titulo, String descripcion, String prioridad, String fechLimite, String categoria, Boolean isCompleted) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechLimite = fechLimite;
        this.categoria = categoria;
        this.isCompleted = isCompleted;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFechLimite() {
        return fechLimite;
    }

    public void setFechLimite(String fechLimite) {
        this.fechLimite = fechLimite;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
