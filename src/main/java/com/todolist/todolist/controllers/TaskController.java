package com.todolist.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.services.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    // @GetMapping("/list-task")
    // public String listTask(Model model) {
    // List<Task> tasks = taskService.getAllTask();
    // model.addAttribute("tasks", tasks);
    // return "index";
    // }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "index";
    }

    @GetMapping("/task/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/task")
    public String saveTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/task/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "form";
        }
        return "redirect:/";
    }
}
