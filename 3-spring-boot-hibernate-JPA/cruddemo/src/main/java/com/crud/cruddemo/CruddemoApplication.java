package com.crud.cruddemo;

import com.crud.cruddemo.DAO.StudentDao;
import com.crud.cruddemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
//    StudentDao StudentDao;


    public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner->{

            //createStudent(studentDao);
            multipleStudent(studentDao);
           // readStudent(studentDao);
            //findAllStudent(studentDao);
            //findStudentByLastName(studentDao);
            //UpdatefirstName(studentDao);
//            RemoveById(studentDao);
           // removeAllStudents(studentDao);
        };
    }

    private void removeAllStudents(StudentDao studentDao) {
        System.out.println("Removing all students");
        int getdeletedstudentcount=studentDao.deleteAll();
        System.out.println(getdeletedstudentcount);
    }

    private void RemoveById(StudentDao studentDao) {
        int id=4;
        //Student student=studentDao.findById(id);
        System.out.println("Deleted student with id="+id);
        studentDao.deleteById(id);

        //System.out.println("Student "+id+" has been deleted"+student);
    }

    private void UpdatefirstName(StudentDao studentDao) {
      int id=1;
      //get student by id
        Student student=studentDao.findById(id);
        student.setFirstName("DUmmy");
        //update your data
        studentDao.update(student);
        //display
        System.out.println("Updated first name "+student.getFirstName());
        System.out.println("All details of updated data "+student);


    }

    private void findStudentByLastName(StudentDao studentDao) {
        //create query
        List<Student> students=studentDao.findbyLastName("poter");
        for(Student student:students)
        {
            System.out.println(student);
        }
    }


    private void findAllStudent(StudentDao studentDao) {
    List<Student> students = studentDao.findAll();
    for (Student student : students) {
        System.out.println(student);
    }

    }


    public  void createStudent(StudentDao studentDao) {

        //create data
        System.out.println("create data");
        Student tempstudent = new Student("paul","dae","qwr@t.com");
        //save data
        System.out.println("save data");

        studentDao.save(tempstudent);
        //display Id
        System.out.println("get data id : "+tempstudent.getId());
        // retrieve data
        int tempid=tempstudent.getId();
        System.out.println("get data "+tempid);




    }
    public void readStudent(StudentDao studentDao) {
        Student tempstudent = new Student("Adley","son","mnr@t.com");
        studentDao.save(tempstudent);
        Student readstudent = studentDao.findById(tempstudent.getId());
        System.out.println("read id give current data "+readstudent);
    }
    public  void multipleStudent(StudentDao studentDao) {

        //create data
        System.out.println("create data");
        Student tempstudent = new Student("paul","dae","qwr@t.com");
        Student tempstudent1 = new Student("harry","poter","qwr@t.com");
        Student tempstudent2 = new Student("forger","madmon","qwr@t.com");

        //save data

        System.out.println("save data");

        studentDao.save(tempstudent);
        studentDao.save(tempstudent1);
        studentDao.save(tempstudent2);

    }

}

