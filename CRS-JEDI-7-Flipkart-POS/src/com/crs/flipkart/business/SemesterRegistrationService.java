/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;

/**
 * @author harsh
 *
 */
public class SemesterRegistrationService {
    Scanner sc = new Scanner(System.in);

    public void addCourse(SemesterRegistration semesterRegistration) {
        System.out.println("Enter the course ID");
        int courseId = sc.nextInt();
        // To be removed.
        System.out.println("Enter the course name");
        String courseName = sc.next();
        Course course = new Course(10, courseName, courseId, "Rahul");
        semesterRegistration.getCourses().add(course);
    }

    public void dropCourse(SemesterRegistration semesterRegistration) {
        System.out.println("Enter the course ID that you want to delete");
        int courseId = sc.nextInt();
        int index = 0;
        for (Course course : semesterRegistration.getCourses()) {
            if (course.getCourseId() == courseId) {
                semesterRegistration.getCourses().remove(index);
                break;
            }
            index++;
        }
    }

    public void showCourse(CourseCatalog courseCatalog) {
        for (Course course : courseCatalog.getCourses()) {
            System.out.println("Course Id --> " + course.getCourseId() + " Course Name -->" + course.getCourseName());
        }
    }
}
