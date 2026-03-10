package com.capgemini.tasktrack.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.tasktrack.repository.TaskRepository;
import com.capgemini.tasktrack.model.Task;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public void saveTask(Task task, MultipartFile file) {

        try {

            if (!file.isEmpty()) {
                task.setImageName(file.getOriginalFilename());
                task.setImageType(file.getContentType());
                task.setImageData(file.getBytes());
            }

            task.setStatus("PENDING");

            repository.save(task);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleStatus(Long id) {

        Task task = repository.findById(id).orElse(null);

        if (task != null) {

            if (task.getStatus().equals("PENDING"))
                task.setStatus("COMPLETE");
            else
                task.setStatus("PENDING");

            repository.save(task);
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public byte[] getTaskImage(Long id) {
        return repository.findById(id).get().getImageData();
    }
}