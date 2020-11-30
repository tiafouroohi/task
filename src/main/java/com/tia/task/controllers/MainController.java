package com.tia.task.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia.task.models.Priority;
import com.tia.task.models.Task;
import com.tia.task.models.User;
import com.tia.task.services.TaskService;
import com.tia.task.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/create")
	public String create(@Valid @ModelAttribute("task")Task task, BindingResult result, Model model) {
		taskService.allTasks();
		model.addAttribute(taskService.allUsers());
		List<User> users = taskService.allUsers();
		model.addAttribute("users", users);
		
		taskService.allPriorities();
		model.addAttribute(taskService.allPriorities());
		List<Priority> priorities = taskService.allPriorities();
		model.addAttribute("priorities", priorities);
	
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String submitTask(@Valid @ModelAttribute("task")Task task, Model model, BindingResult result) {
		taskService.createTask(task);
		return "redirect:/create";
	}
	
	@RequestMapping("/task/{id}")
	public String task(@PathVariable("id")Long id, @ModelAttribute("task")Task task, Model model) {
		model.addAttribute("task", taskService.findTask(id));
		model.addAttribute("user", taskService.allUsers());
		taskService.allTasks();
		model.addAttribute(taskService.allUsers());
		List<User> users = taskService.allUsers();
		model.addAttribute("users", users);
		
		taskService.allPriorities();
		model.addAttribute(taskService.allPriorities());
		List<Priority> priorities = taskService.allPriorities();
		model.addAttribute("priorities", priorities);
		return "task.jsp";
		
	}
	

}
