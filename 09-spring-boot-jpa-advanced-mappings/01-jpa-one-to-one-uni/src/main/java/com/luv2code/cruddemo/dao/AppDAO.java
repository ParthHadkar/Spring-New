package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.model.Instructor;

public interface AppDAO {

    void save(Instructor pInstructor);

    Instructor findInstructorById(int pId);

    void deleteInstructorById(int pId);

}
