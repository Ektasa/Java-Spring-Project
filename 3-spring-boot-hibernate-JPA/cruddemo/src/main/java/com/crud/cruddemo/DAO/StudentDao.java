package com.crud.cruddemo.DAO;

import com.crud.cruddemo.Entity.Student;

import java.util.List;


public interface StudentDao {


   void save(Student students);

    Student findById(int id);
    List<Student> findAll();
    List<Student> findbyLastName(String lastName);
    void update(Student student);
    void deleteById(int id);
    int deleteAll();

}
