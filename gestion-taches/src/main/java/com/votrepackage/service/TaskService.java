package com.votrepackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.votrepackage.model.Task;
import com.votrepackage.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

     public Task updateTask(Long taskId, Task updatedTask) {
        // Vérifiez si la tâche avec l'ID taskId existe
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));

        // Mettez à jour les propriétés de la tâche existante avec les nouvelles valeurs
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());

        // Enregistrez la tâche mise à jour dans la base de données
        return taskRepository.save(existingTask);
    }

    // Ajoutez d'autres méthodes pour la gestion des tâches
    
}
