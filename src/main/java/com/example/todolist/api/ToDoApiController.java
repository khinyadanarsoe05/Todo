package com.example.todolist.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/todos")
public class ToDoApiController {
    private final TodoService todoService;
public ToDoApiController(TodoService todoService){
    this.todoService=todoService;
}
@GetMapping()
public List<Todo> all() {
    List<Todo> todos=todoService.all();
    return todos;
}
@PostMapping()
public List<Todo> create(@RequestParam String title) {
    todoService.add(title);
    List<Todo> todos=todoService.all();
    return todos;
}
@PatchMapping("/{id}")
public List<Todo> edit(@PathVariable Long id,@RequestParam String title){
    todoService.update(id, title);
     List<Todo> todos=todoService.all();
    return todos;
}
@DeleteMapping("/{id}")
public List<Todo> drop(@PathVariable Long id){
   todoService.drop(id);
     List<Todo> todos=todoService.all();
    return todos;
}
 @GetMapping("/toggle/{id}")
 public List<Todo> toggle(@PathVariable Long id) {
    todoService.toggle(id);
    List<Todo> todos=todoService.all();
    return todos;
 }
 @GetMapping("/filter/{id}")
 public List<Todo> filter(@PathVariable boolean complete) {
    List<Todo> todos= todoService.filter(complete);
    return todos;
 }
 
}
