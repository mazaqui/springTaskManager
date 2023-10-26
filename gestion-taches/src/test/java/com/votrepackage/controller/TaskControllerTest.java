package com.votrepackage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.votrepackage.model.Task;
import com.votrepackage.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task.");

        when(taskService.createTask(task)).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                .content("{\"title\":\"Sample Task\",\"description\":\"This is a sample task.\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllTasks() throws Exception {
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

        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(status().isOk());
    }

    // Ajoutez d'autres tests pour d'autres méthodes du contrôleur
}
