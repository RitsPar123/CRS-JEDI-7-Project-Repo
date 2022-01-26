/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
    Connection conn = CRSDb.getConnect();

    public boolean addCourse(Course course) {
        try {
            // Connection conn = CRSDb.getConnect();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(SQLQueriesConstant.ADD_COURSE);
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getProfessor());
            stmt.setString(3, course.getCourseName());

            stmt.executeUpdate();
            conn.close();

            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String id) {
        // TODO Auto-generated method stub

        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE);
            stmt.setString(1, id);

            int row = stmt.executeUpdate();
            conn.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addProfessor(Professor professor) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.ADD_PROFESSOR);

            pstmtP.setString(1, professor.getId());
            pstmtP.setString(2, professor.getDepartment());

            pstmtP.executeUpdate();

            conn.close();

            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean approveStudent(String SId) {
        // TODO Auto-generated method stub
        Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENT);

            pstmtP.setString(1, SId);

            pstmtP.executeUpdate();
            conn.close();

            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> viewPendingApproval() {
        // TODO Auto-generated method stub
        Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.PENDING_STUDENT);

            ResultSet resultSet = pstmtP.executeQuery();

            List<Student> studentList = new ArrayList<Student>();
            while (resultSet.next()) {
                Student stud = new Student();
                stud.setId(resultSet.getString(1));
                stud.setBranch(resultSet.getString(2));
                stud.setUserName(resultSet.getString(3));

                studentList.add(stud);
            }

            conn.close();

            return studentList;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> viewCourse() {
        // TODO Auto-generated method stub
        Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.VIEW_COURSES);

            ResultSet resultSet = pstmtP.executeQuery();

            List<Course> courseList = new ArrayList<Course>();
            while (resultSet.next()) {
                Course cour = new Course();
                cour.setCourseId(resultSet.getString("CourseId"));
                cour.setCourseName(resultSet.getString("CourseName"));
                cour.setCount(resultSet.getInt("SeatCount"));

                courseList.add(cour);
            }

            conn.close();

            return courseList;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Set<String> viewSelectedCourse(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.VIEW_SELECT_COURSE);
            
            pstmtP.setString(1, studentId);

            ResultSet resultSet = pstmtP.executeQuery();

            Set<String> courseList = new HashSet();
            while (resultSet.next()) {
                courseList.add(resultSet.getString("CourseId"));
            }

            //conn.close();

            return courseList;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public int getCourseList(String courseId) {
		// TODO Auto-generated method stub
		
		try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_SEAT);
            
            pstmtP.setString(1, courseId);

            ResultSet resultSet = pstmtP.executeQuery();
            
            if(resultSet.next()) {
            	return resultSet.getInt("SeatCount");
            }
            
            conn.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return 0;
	}

	@Override
	public boolean updateRegistered(String studentId) {
		// TODO Auto-generated method stub
		
		 Connection conn = CRSDb.getConnect();
	        try {
	            PreparedStatement pstmtP;
	            pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENT_REGISTRATION);

	            pstmtP.setString(1, studentId);

	            pstmtP.executeUpdate();
	            conn.close();

	            return true;

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

		return false;
	}
	
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<>();
		
		Connection connection = CRSDb.getConnect();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("");
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getString(0));
				course.setProfessor(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				courses.add(course);
			}
			
			return courses;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return courses;
	}
	
}

