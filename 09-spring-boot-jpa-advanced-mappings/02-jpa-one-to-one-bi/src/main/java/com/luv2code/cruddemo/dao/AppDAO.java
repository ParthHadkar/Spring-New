package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;

public interface AppDAO {

    void save(Instructor pInstructor);

    Instructor findInstructorById(int pId);

    void deleteInstructorById(int pId);

    InstructorDetail findInstructorDetailById(int pId);

    void deleteInstructorDetailById(int pId);

}
