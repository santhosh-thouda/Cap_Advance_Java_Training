package com.capgemini.tasktrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.tasktrack.model.Task;
import com.capgemini.tasktrack.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("taskList", service.getAllTasks());
        return "task-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(Task task,
                           @RequestParam("imageFile") MultipartFile file) {

        service.saveTask(task, file);
        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable Long id) {
        service.toggleStatus(id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/tasks";
    }
    
    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getTaskImage(@PathVariable Long id) {

        byte[] image = service.getTaskImage(id);

        return ResponseEntity
                .ok()
                .header("Content-Type", "image/jpeg")
                .body(image);
    }
}