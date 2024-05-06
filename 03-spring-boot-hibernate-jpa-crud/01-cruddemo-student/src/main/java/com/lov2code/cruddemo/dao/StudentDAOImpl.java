package com.lov2code.cruddemo.dao;

import com.lov2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define EntityManager
    private EntityManager entityManager;
    // Inject EntityManager using construction injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // use EntityManager to save Data
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
        // Return results from query
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:qLastName", Student.class);
        // Set query parameters
        query.setParameter("qLastName",lastName);
        // Return results from query
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // reteive the student
        Student student = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRows;
    }
}
