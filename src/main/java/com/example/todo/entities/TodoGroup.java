package com.example.todo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class TodoGroup  {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "todoGroup", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<TodoItem> todoItems = new ArrayList<>();

    public TodoGroup(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TodoGroup todoGroup)) {
            return false;
        }

        return Objects.equals(this.id, todoGroup.id) && Objects.equals(this.name, todoGroup.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "TodoGroup{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
