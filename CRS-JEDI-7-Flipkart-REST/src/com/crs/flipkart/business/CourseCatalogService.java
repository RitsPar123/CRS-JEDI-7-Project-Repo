package com.crs.flipkart.business;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;

public class CourseCatalogService implements CourseCatalogServiceInterface{

	 private static Logger logger = Logger.getLogger(CourseCatalogService.class);


    /**
     * Method to add courses to the courseCatalog
     * @param courseCatalog : Object which stores courses
     * @param course : Object for course which is to be added in courseCatalog
     * @return 
     */
    public void addCourse(CourseCatalog courseCatalog, Course course) {
        courseCatalog.getCourses().add(course);
    }

    
    /**
     * Method to drop courses from the courseCatalog
     * @param courseCatalog : object which stores courses
     * @param course : Object for course which is to be added in courseCatalog
     */
    public void dropCourse(CourseCatalog courseCatalog, Course course) {
        int index = 0;
        for (Course c : courseCatalog.getCourses()) {
            if (c.getCourseId() == course.getCourseId())
                courseCatalog.getCourses().remove(index);
            index++;
        }
    }
}
