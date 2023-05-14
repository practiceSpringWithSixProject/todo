package com.example.todo.response;

import java.net.http.HttpHeaders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ResponseEntity<T> {

  private HttpStatus status;
  private T data;
  private Error error;

  public static <T> ResponseEntity<T> success(T data) {
    return new ResponseEntity<>(HttpStatus.OK, data, null);
  }

  public static <T> ResponseEntity<T> successHeader(T data, HttpHeaders headers) {
    return new ResponseEntity<>(HttpStatus.OK, data, null);
  }

  public static <T> ResponseEntity<T> fail(HttpStatus status, String message) {
    return new ResponseEntity<>(status, null,
        new Error(status.value(), message));
  }

  @Getter
  @AllArgsConstructor
  static class Error {

    private int statusCode;
    private String message;
  }

}
