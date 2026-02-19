package com.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
public void setId(Long id) {
    this.id = id;
}
public void setTitle(String title) {
    this.title = title;
}
public void setCompleted(boolean completed) {
    this.completed = completed;
}
private String title;
private boolean completed;
public Long getId() {
    return id;
}
public String getTitle() {
    return title;
}
public boolean isCompleted() {
    return completed;
}

}
