package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
