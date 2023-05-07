package com.example.todo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class TodoGroup  {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "todoGroup", cascade = CascadeType.DETACH)
    private List<TodoItem> todoItems = new ArrayList<TodoItem>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TodoGroup)) {
            return false;
        }

        TodoGroup todoGroup = (TodoGroup) o;

        return Objects.equals(this.id, todoGroup.id) && Objects.equals(this.name, todoGroup.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
