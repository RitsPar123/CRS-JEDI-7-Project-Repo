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
import com.crs.flipkart.exception.CourseNotFoundException;

/**
 * @author harsh
 *
 */
public class SemesterRegistrationService implements SemesterRegistrationServiceInterface{
    
	private static Logger logger = Logger.getLogger(SemesterRegistrationService.class);
	
	Scanner sc = new Scanner(System.in);
    RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
    
    public boolean addCourse(String studentId, String courseId)  throws CourseNotFoundException {
    	
    	
    	logger.info("Adding course");
    	
    	try
    	{
    		registeredCoursesDaoInterface.isCourseAvailable(courseId);
    	}
    	catch(CourseNotFoundException ex)
    	{
    		throw ex;
    	}
  
        if(registeredCoursesDaoInterface.hasCourse(courseId,studentId)) {
  
        	return false;
        }
        
        
        return registeredCoursesDaoInterface.addCourse(courseId,studentId);
    }

    public boolean dropCourse(String studentId, String courseId) throws Exception
    {
    	
    	logger.info("Dropping Course");
      
        
        if(!registeredCoursesDaoInterface.hasCourse(courseId,studentId)) 
        {
        	
        	return false;
        }
        
      try{
        registeredCoursesDaoInterface.dropCourse(courseId, studentId);
      }
      catch(Exception ex)
      {
    	  throw ex;
      } 
      
    return true;}

    public  List<Course> showCourse() 
    {
    	
    	logger.info("Showing Course");
    	//System.out.println("Courses offered in this semester are: ");
    	// Fetch courses from course catalog
    	
    	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
    	List<Course> availableCourses = adminDaoInterface.getAllCourse();
    	return availableCourses;
       
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

	//@Override
	/*public boolean addCourse(SemesterRegistration semesterRegistration) {
		// TODO Auto-generated method stub
		return false;
	}*/
    
}
