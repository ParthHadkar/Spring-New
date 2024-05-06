package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.model.Course;
import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;
import com.luv2code.cruddemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager pEntityManager){
        this.entityManager = pEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor pInstructor) {
        entityManager.persist(pInstructor);
    }

    @Override
    public Instructor findInstructorById(int pId) {
        return entityManager.find(Instructor.class, pId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int pId) {
        Instructor lInstructor =  entityManager.find(Instructor.class, pId);
        List<Course> lCourseList = lInstructor.getCourses();
        for(Course lCourse: lCourseList){
            lCourse.setInstructor(null);
        }
        entityManager.remove(lInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int pId) {
        return entityManager.find(InstructorDetail.class, pId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int pId) {
        InstructorDetail lInstructorDetail =  entityManager.find(InstructorDetail.class, pId);

        // remove the associated object reference
        // break bidirectional link
        lInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(lInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int pId) {
        TypedQuery<Course> lQuery = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        lQuery.setParameter("data",pId);

        List<Course> lCourseList = lQuery.getResultList();
        return lCourseList;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int pId) {
        TypedQuery<Instructor> lQuery = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail " +
                " where i.id = :data", Instructor.class);
        lQuery.setParameter("data",pId);

        Instructor lInstructor = lQuery.getSingleResult();

        return  lInstructor;
    }

    @Override
    @Transactional
    public void update(Instructor pInstructor) {
        entityManager.merge(pInstructor);
    }

    @Override
    @Transactional
    public void update(Course pCourse) {
        entityManager.merge(pCourse);
    }

    @Override
    public Course findCourseById(int pId) {
        return  entityManager.find(Course.class, pId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int pId) {
        Course lCourse = entityManager.find(Course.class, pId);
        entityManager.remove(lCourse);
    }

    @Override
    @Transactional
    public void save(Course pCourse) {
        entityManager.persist(pCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int pId) {
        TypedQuery<Course> lQuery = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        lQuery.setParameter("data", pId);
        Course lCourse = lQuery.getSingleResult();
        return lCourse;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int pId) {
        TypedQuery<Course> lQuery = entityManager.createQuery("select c from Course c JOIN FETCH c.students where c.id = :data", Course.class);
        lQuery.setParameter("data", pId);
        Course lCourse = lQuery.getSingleResult();
        return lCourse;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int pId) {
        TypedQuery<Student> lQuery = entityManager.createQuery("select s from Student s JOIN FETCH s.courses where s.id = :data", Student.class);
        lQuery.setParameter("data", pId);
        Student lStudent = lQuery.getSingleResult();
        return lStudent;
    }

    @Override
    @Transactional
    public void update(Student pStudent) {
        entityManager.merge(pStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int pId) {
        Student lStudent = entityManager.find(Student.class, pId);
        entityManager.remove(lStudent);
    }


}
