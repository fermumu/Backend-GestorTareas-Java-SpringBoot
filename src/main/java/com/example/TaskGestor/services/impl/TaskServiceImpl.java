package com.example.TaskGestor.services.impl;
import com.example.TaskGestor.models.TaskModel;
import com.example.TaskGestor.repositories.TaskRepository;
import com.example.TaskGestor.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskModel> listaTareas() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel crearTarea(TaskModel task) {
        TaskModel tasks = new TaskModel();
        tasks.setTitulo(task.getTitulo());
        tasks.setDescripcion(task.getDescripcion());
        tasks.setPrioridad(task.getPrioridad());
        tasks.setFechLimite(task.getFechLimite());
        tasks.setCategoria(task.getCategoria());
        tasks.setIsCompleted(task.getIsCompleted());
        return taskRepository.save(tasks);
    }

    @Override
    public void eliminarTarea(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void editarTarea(Long id, TaskModel editTask) {
        TaskModel taskExist = taskRepository.findById(id).orElse(null);
        if(taskExist != null){
            taskExist.setTitulo(editTask.getTitulo());
            taskExist.setDescripcion(editTask.getDescripcion());
            taskExist.setPrioridad(editTask.getPrioridad());
            taskExist.setFechLimite(editTask.getFechLimite());
            taskExist.setCategoria(editTask.getCategoria());
            taskExist.setIsCompleted(editTask.getIsCompleted());
            taskRepository.save(taskExist);
        }else {
            throw new RuntimeException("Tarea no encontrada");
        }
    }

    @Override
    public Optional<TaskModel> obtenerById(Long id) {
        return taskRepository.findById(id);
    }
}
