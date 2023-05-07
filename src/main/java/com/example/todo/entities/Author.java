package com.example.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Author {
    private @Id @GeneratedValue Long id;
    private String name;

    public Author() {

    }

    public Author(String bilboBaggins) {
        this.name = bilboBaggins;
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

        if (!(o instanceof Author)) {
            return false;
        }

        Author author = (Author) o;

        return Objects.equals(this.id, author.id) && Objects.equals(this.name, author.name);
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
