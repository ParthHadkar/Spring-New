package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.model.Course;
import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;
import com.luv2code.cruddemo.model.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor pInstructor);

    Instructor findInstructorById(int pId);

    void deleteInstructorById(int pId);

    InstructorDetail findInstructorDetailById(int pId);

    void deleteInstructorDetailById(int pId);

    List<Course> findCoursesByInstructorId(int pId);

    Instructor findInstructorByIdJoinFetch(int pId);

    void update(Instructor pInstructor);

    void update(Course pCourse);

    Course findCourseById(int pId);

    void deleteCourseById(int pId);

    void save(Course pCourse);

    Course findCourseAndReviewsByCourseId(int pId);

    Course findCourseAndStudentsByCourseId(int pId);

    Student findStudentAndCoursesByStudentId(int pId);

    void update(Student pStudent);

    void deleteStudentById(int pId);

}
