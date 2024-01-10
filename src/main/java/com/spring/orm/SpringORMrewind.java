package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringORMrewind {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        /*
        
        Student student = new Student("Mohit Sehgal", "Kashmir");
        studentDao.insertStudent(student);
        
        */
        
        /*
        
        Student student = studentDao.getStudent(3);
        System.out.println(student.toString());
        
        */
        
        /*
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student : students){
            System.out.println(student.toString());
        }       
        
        */
        
        /*
        
        Student student = studentDao.getStudent(4);
        student.setCity("Hyderabad");
        studentDao.updateStudent(student);
        
        */
        
        /*
        
        studentDao.deleteStudent(4);
        
        */
        
        /*
        
        List<Student> students = studentDao.getAllStudentsByNameCity("Anumoy Nandy", "Patna");
        for(Student student : students){
            System.out.println(student.toString());
        }
        
        */
        
        /*
        
         int deletedEntities = studentDao.deleteStudentByNameCity("Mohit Sehgal", "Chennai"); 
         System.out.println("Records deleted " + deletedEntities);        
        
        */
        
        /*
        
        int updatedEntities = studentDao.updatedStudentByCity("Mumbai", "Delhi");
        System.out.println("Records updated " + updatedEntities);
        
        */
        

    }
}
