/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

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
    
	private static Logger logger = Logger.getLogger(SemesterRegistrationService.class);
	
	Scanner sc = new Scanner(System.in);
    RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
    
    
    /*
     Student can add course for Semester Registration
     */
    public boolean addCourse(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Adding course");
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
    
    /*
    Student can drop course for Semester Registration
    */
    public void dropCourse(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Dropping Course");
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
    
    /*
    Student can see course that are available 
    */
    public void showCourse() {
    	
    	logger.info("Showing Course");
    	System.out.println("Courses offered in this semester are: ");
    	// Fetch courses from course catalog
    	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
    	
    	List<Course> availableCourses = adminDaoInterface.getAllCourse();
    	
    	availableCourses.forEach(course->{System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());});
//    	for(Course course: availableCourses) {
//    		System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());
//    	}
    	
    	System.out.println("-----------------------------------------------");  
    	System.out.println("-----------------------------------------------"); 
    }
    
    /*
    Student can see selected courses
    */
    public void showSelectedCourses(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Showing selected courses");
    	System.out.println("You have selected the following courses!");
    	List<Course> selectedCourses = registeredCoursesDaoInterface.getSelectedCourses(semesterRegistration.getStudentId());
    	
    	selectedCourses.forEach(course->{System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());});
//    	for(Course course: selectedCourses) {
//    		System.out.println("Course ID: " + course.getCourseId() + " Course Name: " + course.getCourseName());
//    	}
    	
    	System.out.println("-----------------------------------------------");
    }
    
}
