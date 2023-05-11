package com.example.todo.dto;


import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BucketDto {

  private String bucketName;

  @Builder
  public Bucket bucketDto(String bucketName, Author author) {
    Bucket bucket = new Bucket();
    bucket.setBucketName(bucketName);
    return bucket;
  }
}
