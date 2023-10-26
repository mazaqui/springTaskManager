package com.votrepackage.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.votrepackage.model.Task;
import com.votrepackage.repository.TaskRepository;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        taskService = new TaskService(taskRepository);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task.");

        when(taskRepository.save(task)).thenReturn(task);

        Task createdTask = taskService.createTask(task);
        assertEquals("Sample Task", createdTask.getTitle());
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Sample Task 1");
        task1.setDescription("This is the first sample task.");
        tasks.add(task1);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Sample Task 2");
        task2.setDescription("This is the second sample task.");
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> retrievedTasks = taskService.getAllTasks();
        assertEquals(2, retrievedTasks.size());
    }

    // Ajoutez d'autres tests pour d'autres méthodes du service
}
