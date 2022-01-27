/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author harsh
 *
 */
public class RegisteredCoursesDaoOperation implements RegisteredCoursesDaoInterface {

	public List<Course> getApprovedCoursesById(String id) {
		List<Course> courses = new ArrayList<Course>();

		Connection connection = CRSDb.getConnect();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.GET_STUDENT_ACOURSES_BY_ID);

			pstmt.setString(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getString("CourseId"));
				courses.add(course);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return courses;
	}

	public boolean addCourse(String courseId, String studentId) {
		// SQL create query
		Connection connection = CRSDb.getConnect();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.ADD_COURSE_FOR_STUDENT);

			pstmt.setString(1, courseId);
			pstmt.setString(2, studentId);

			int done = pstmt.executeUpdate();

			if (done == 1) {
				System.out.println("Course added successfully!");
			} else {
				System.out.println("Error! Try again later");
			}
			return done == 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public void dropCourse(String courseId, String studentId) {
		Connection connection = CRSDb.getConnect();

		try {

			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.DROP_COURSE_FOR_STUDENT);

			pstmt.setString(1, courseId);
			pstmt.setString(2, studentId);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public boolean hasCourse(String courseId, String studentId) {
		Connection connection = CRSDb.getConnect();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.HAS_COURSE_ADDED);
			pstmt.setString(1, courseId);
			pstmt.setString(2, studentId);

			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) {
				return false;
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Course> getSelectedCourses(String id) {
		List<Course> courses = new ArrayList<Course>();

		Connection connection = CRSDb.getConnect();

		try {
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.GET_STUDENT_SCOURSES_BY_ID);

			pstmt.setString(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getString("CourseId"));
				courses.add(course);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return courses;

	}

}
