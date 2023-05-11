package com.example.todo.repository;

import com.example.todo.model.Bucket;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

  @Query("SELECT b from Bucket b where b.author.id = :authorId")
  Optional<List<Bucket>> findAllByAuthor_Id(Long authorId);

}
