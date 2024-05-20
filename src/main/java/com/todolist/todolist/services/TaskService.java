package com.todolist.todolist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.todolist.todolist.models.Task;

@Service
public class TaskService {
    // public List<Task> getAllTask() {
    // List<Task> tasks = new ArrayList<>();
    // tasks.add(new Task(1L, "A", true));
    // tasks.add(new Task(2L, "B", false));
    // tasks.add(new Task(3L, "C", false));

    // return tasks;
    // }

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
