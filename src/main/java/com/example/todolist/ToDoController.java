package com.example.todolist;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/todo")
public class ToDoController {

    private final TodoService todoService;

    ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }
@GetMapping
public String all(Model model) {
   List<Todo> todos=todoService.all();
model.addAttribute("todos", todos);
    return "todo/all";
}
@GetMapping("/add")
public String add() {
    return "todo/add";
}
@PostMapping("/add")
public String create(@RequestParam String title) {
    todoService.add(title);
   return "redirect:/todo";
}
@GetMapping("edit/{id}")
public String edit(@PathVariable Long id,Model model) {
    Todo todo=todoService.get(id);
    model.addAttribute("todo", todo);
    return "todo/edit";
}
@PostMapping("edit/{id}")
public String update(@PathVariable Long id,@RequestParam String title) {
    
    todoService.update(id, title);
    return "redirect:/todo";
}
@GetMapping("drop/{id}")
public String drop(@PathVariable Long id) {
    todoService.drop(id);
    return "redirect:/todo";
}
@GetMapping("toggle/{id}")
public String getMethodName(@PathVariable Long id) {
    todoService.toggle(id);
    return "redirect:/todo";
}
@GetMapping("filter/{complete}")
public String getMethodName(@PathVariable boolean complete,Model model) {
    List<Todo> todos=todoService.filter(complete);
    model.addAttribute("todos", todos);
    return"todo/all";
}

}
