package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;

public class CourseCatalogService implements CourseCatalogServiceInterface{
    /*
    *Method for get courses from courseCatalog
    *@param courseCatalog:Object which stores courses
    *@param course:Object for course which is to be added in courseCatalog;
    */
    public void addCourse(CourseCatalog courseCatalog, Course course) {
        courseCatalog.getCourses().add(course);
    }

    /*
    *Method for Droping courses from CourseCatalog;
    *@param courseCatalog:Object which stores courses
    *@param course:Object for course which is to be added in courseCatalog;
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
