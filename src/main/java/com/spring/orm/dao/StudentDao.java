package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    public StudentDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public StudentDao() {
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Transactional
    public int insertStudent(Student student){
        Integer row = (Integer)hibernateTemplate.save(student);
        return row;
    }
    
    public Student getStudent(int id){
        Student student = hibernateTemplate.get(Student.class, id);
        return student;
    }
    
    public List<Student> getAllStudents(){
        List<Student> students = hibernateTemplate.loadAll(Student.class);
        return students;
    }
    
    public List<Student> getAllStudentsByNameCity(String name, String city){
        String[] names = {"name","city"};
        Object[] values = {name, city};
        String query = "from Student where name = :name or city = :city";
        List<Student> students = (List<Student>)hibernateTemplate.findByNamedParam(query, names, values);
        return students;
    }
    
    @Transactional
    public void updateStudent(Student student){
        hibernateTemplate.update(student);
    }
    
    @Transactional
    public int updatedStudentByCity(String prevCity, String newCity){
        int rows = hibernateTemplate.execute(session->{
           String hqlQuery = "update Student set city = :newCity where city = :prevCity";
           Query q = session.createQuery(hqlQuery);
           q.setParameter("prevCity", prevCity);
           q.setParameter("newCity", newCity);
           int updatedEntities = q.executeUpdate();
           return updatedEntities;
        });
        return rows;
    }
    
    @Transactional
    public void deleteStudent(int id){
        Student student = hibernateTemplate.get(Student.class, id);
        hibernateTemplate.delete(student);
    }
    
    @Transactional
    public int deleteStudentByNameCity(String name, String city){
         int rows = hibernateTemplate.execute(session->{
             String hqlQuery = "delete from Student where name = :name or city = :city";
             Query q = session.createQuery(hqlQuery);
             q.setParameter("name", name);
             q.setParameter("city", city);
             int deletedEntities = q.executeUpdate();
             return deletedEntities;
         });
         return rows;
    }
}
