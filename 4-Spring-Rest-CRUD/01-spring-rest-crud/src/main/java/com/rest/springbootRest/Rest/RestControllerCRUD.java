package com.rest.springbootRest.Rest;

import com.rest.springbootRest.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class RestControllerCRUD {

    @RestController
    @RequestMapping("/api")
    public static class TestRestController {

       private List<Student> students;

        @PostConstruct
        public void load_data() {
            students = new ArrayList<>();
            students.add(new Student("puri","dev"));
            students.add(new Student("Adley","dev"));
            students.add(new Student("pujari","dev"));

        }
        @GetMapping("/students")
        public List<Student> getStudents() {
           return students;
        }
         @GetMapping("/allstudents")
        public List<Student> getStudents() {
           return students;
        }
        @GetMapping("/students/{StudentId}")
                public Student getstudentsindex(@PathVariable int StudentId)
        {
            if((StudentId >=students.size())|| (StudentId <0))
            {
                throw new studentNotFoundException("Student id not found "+ StudentId);
            }
            return students.get(StudentId);
        }
    }
      // Add Exception Handler using @Exceptional Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(studentNotFoundException stexp)
    {
      StudentErrorResponse error=new StudentErrorResponse();

      error.setStatus(HttpStatus.NOT_FOUND.value());
      error.setMessage(stexp.getMessage());
      error.setTimestamp(System.currentTimeMillis());

      return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // Add exception handlers
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleBadException(studentNotFoundException ex)
    {
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
