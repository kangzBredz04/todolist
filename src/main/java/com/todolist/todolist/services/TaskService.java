package com.todolist.todolist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.todolist.todolist.models.Task;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Task task) {
        if (task.getId() == null) {
            task.setId(counter.incrementAndGet());
        }
        tasks.add(task);
    }

    public void delete(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
