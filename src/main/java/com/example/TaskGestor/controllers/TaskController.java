package com.example.TaskGestor.controllers;

import com.example.TaskGestor.models.TaskModel;
import com.example.TaskGestor.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskModel>listaTareas(){
        return taskService.listaTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel>tareaById(@PathVariable Long id){
        return taskService.obtenerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<String>crearTarea(@RequestBody @Valid TaskModel task){
        taskService.crearTarea(task);
        return ResponseEntity.ok("Tarea creada");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String>editasById(@PathVariable Long id, @RequestBody TaskModel editTask){
        taskService.editarTarea(id, editTask);
        return ResponseEntity.ok("Tarea editada");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String>eliminarTarea(@PathVariable Long id){
        taskService.eliminarTarea(id);
        return ResponseEntity.ok("Tarea eliminada");
    }
}
