package com.example.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepo;

@Service
public class TodoService {
    private final TodoRepo todoRepo;
public TodoService(TodoRepo todoRepo){
    this.todoRepo=todoRepo;
}
public List<Todo> all(){
    List<Todo> todos=todoRepo.findAll();
    return todos;
}
public void add(String title){
    Todo todo=new Todo();
    todo.setTitle(title);
    todo.setCompleted(false);
    todoRepo.save(todo);
}
public Todo get(Long id){
    Todo todo=todoRepo.findById(id).orElse(null);
    return todo;
}
public void update(Long id,String title){
    Todo todo=todoRepo.findById(id).orElse(null);
    if(todo != null){
    todo.setTitle(title);
    todoRepo.save(todo);
    }
}
public void drop(Long id){
    todoRepo.deleteById(id);
    
}
public void toggle(Long id){
    Todo todo=todoRepo.findById(id).orElse(null);
    if(todo != null){
        todo.setCompleted(!todo.isCompleted());
        todoRepo.save(todo);
    }
}
public List<Todo> filter(boolean complete){
    List<Todo> tds=new ArrayList<>();
    List<Todo> todos=todoRepo.findAll();
    for(Todo todo:todos){
        if(todo.isCompleted() == complete){
            tds.add(todo);
        }
    }
    return tds;
}
}
