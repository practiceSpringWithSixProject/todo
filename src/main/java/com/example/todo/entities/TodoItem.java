package com.example.todo.entities;

import com.example.todo.utils.constants.Priority;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private  Long id;

    @Setter
    private Priority priority;

    @Setter
    private String title;

    @Setter
    private String content;

    @Setter
    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @Setter
    private LocalDateTime dueDate;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TodoItem)) {
            return false;
        }

        TodoItem todo = (TodoItem) o;

        return Objects.equals(this.id, todo.id) && Objects.equals(this.author.getId(), todo.author.getId());
    }

    public int hashCode() {
        return Objects.hash(this.id, this.title, this.author.getId());
    }

    @Override
    public String toString() {
        return "Todo {" + "id=" + this.id + ", name='" + this.title + '\'' + ", author='" + this.author.getName() + '\'' + '}';
    }
}
