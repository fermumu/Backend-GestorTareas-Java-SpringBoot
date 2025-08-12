package com.example.TaskGestor.services;

import com.example.TaskGestor.models.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskModel>listaTareas();
    TaskModel crearTarea(TaskModel task);
    void eliminarTarea(Long id);
    void editarTarea(Long id, TaskModel editTask);
    Optional<TaskModel>obtenerById(Long id);
}
