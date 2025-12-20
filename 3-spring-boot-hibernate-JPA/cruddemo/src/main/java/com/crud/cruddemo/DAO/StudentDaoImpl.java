package com.crud.cruddemo.DAO;


import com.crud.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

 private EntityManager entityManager;

 @Autowired
 public StudentDaoImpl(EntityManager entityManager) {
     this.entityManager = entityManager;

 }

    @Override
    @Transactional
    public void save(Student students) {
        entityManager.persist(students);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = entityManager.createQuery("from Student order by lastName asc ", Student.class).getResultList();
    return students;
 }

    @Override
    public List<Student> findbyLastName(String lastName) {
        TypedQuery<Student> query=entityManager.createQuery
                ("from Student where lastName=:theData",Student.class);
        query.setParameter("theData",lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
     entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
     Student student=entityManager.find(Student.class,id);
     entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
       int getcountdetleted=entityManager.createQuery("Delete from Student").executeUpdate();
       return getcountdetleted;
    }


    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }






}
