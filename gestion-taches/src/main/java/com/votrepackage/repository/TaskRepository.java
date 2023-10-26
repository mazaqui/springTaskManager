package com.votrepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.votrepackage.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Vous pouvez ajouter des méthodes personnalisées pour la recherche ou la manipulation des tâches
}
