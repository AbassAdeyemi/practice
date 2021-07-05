package com.example.practicejava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

  private static final List<Student> STUDENTS =
      List.of(new Student(1, "Aaron Lennon"), new Student(2, "Peter Cech"));

  @GetMapping()
  public List<Student> getStudents() {
    return STUDENTS;
  }
}
