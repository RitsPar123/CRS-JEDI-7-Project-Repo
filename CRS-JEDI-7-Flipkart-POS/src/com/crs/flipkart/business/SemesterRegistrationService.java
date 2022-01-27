/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;

/**
 * @author harsh
 *
 */
public class SemesterRegistrationService implements SemesterRegistrationServiceInterface{
    Scanner sc = new Scanner(System.in);

    RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
    
    public boolean addCourse(SemesterRegistration semesterRegistration) {
    	    	
        System.out.println("Enter the course ID");
        String courseId = sc.next();
        
        if(registeredCoursesDaoInterface.hasCourse(courseId,semesterRegistration.getStudentId())) {
        	System.out.println("You have this course added already!");
        	return false;
        }
        
        System.out.println("Course with course id " + courseId + " added successfully!");
        System.out.println("-----------------------------------------------"); 
        System.out.println("-----------------------------------------------"); 
        
        return registeredCoursesDaoInterface.addCourse(courseId,semesterRegistration.getStudentId());
    }

    public void dropCourse(SemesterRegistration semesterRegistration) {
        System.out.println("Enter the course ID that you want to delete");
        String courseId = sc.next();
        
        if(!registeredCoursesDaoInterface.hasCourse(courseId,semesterRegistration.getStudentId())) {
        	System.out.println("You do not have this course added!");
        	return;
        }
        
        registeredCoursesDaoInterface.dropCourse(courseId, semesterRegistration.getStudentId());
        
        System.out.println("Course with course id " + courseId + " deleted Successfully!");
        
        System.out.println("-----------------------------------------------"); 
        System.out.println("-----------------------------------------------"); 
        
    }

    public void showCourse() {
    	System.out.println("Courses offered in this semester are: ");
    	// Fetch courses from course catalog
    	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
    	
    	List<Course> availableCourses = adminDaoInterface.getAllCourse();
    	
    	for(Course course: availableCourses) {
    		System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());
    	}
    	
    	System.out.println("-----------------------------------------------");  
    	System.out.println("-----------------------------------------------"); 
    }
    
    public void showSelectedCourses(SemesterRegistration semesterRegistration) {
    	System.out.println("You have selected the following courses!");
    	List<Course> selectedCourses = registeredCoursesDaoInterface.getSelectedCourses(semesterRegistration.getStudentId());
    	
    	for(Course course: selectedCourses) {
    		System.out.println("Course ID: " + course.getCourseId() + " Course Name: " + course.getCourseName());
    	}
    	
    	System.out.println("-----------------------------------------------");
    }
    
}
