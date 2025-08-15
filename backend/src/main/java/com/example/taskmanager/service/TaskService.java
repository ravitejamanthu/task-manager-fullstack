package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public List<TaskResponse> getAllTasks() {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        return taskRepository.findByUserIdOrderByCreatedAtDesc(user.getId())
                .stream()
                .map(this::convertToTaskResponse)
                .collect(Collectors.toList());
    }
    
    public TaskResponse createTask(TaskRequest taskRequest) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        Task task = new Task(taskRequest.getTitle(), taskRequest.getDescription(), user);
        Task savedTask = taskRepository.save(task);
        
        return convertToTaskResponse(savedTask);
    }
    
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }
        
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You can only update your own tasks");
        }
        
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        
        Task updatedTask = taskRepository.save(task);
        return convertToTaskResponse(updatedTask);
    }
    
    public TaskResponse toggleTaskCompletion(Long taskId) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }
        
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You can only update your own tasks");
        }
        
        task.setCompleted(!task.isCompleted());
        Task updatedTask = taskRepository.save(task);
        
        return convertToTaskResponse(updatedTask);
    }
    
    public void deleteTask(Long taskId) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username).orElse(null);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }
        
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You can only delete your own tasks");
        }
        
        taskRepository.delete(task);
    }
    
    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
    
    private TaskResponse convertToTaskResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
