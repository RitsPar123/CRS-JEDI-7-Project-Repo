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

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.exception.CourseNotAddedException;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author harsh
 *
 */
public class RegisteredCoursesDaoOperation implements RegisteredCoursesDaoInterface {
	 private static Logger logger = Logger.getLogger(PaymentDaoOperations.class);


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
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Exception" + e.getMessage());
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
			pstmt.setString(3,null);

			int done = pstmt.executeUpdate();

			if (done == 1) {
				logger.info("Course added successfully!");
			} else {
				logger.error("Error! Try again later");
				throw new CourseNotAddedException(courseId);
			}
			return done == 1;

		}catch(CourseNotAddedException u){
			logger.error("Exception" + u.getMessage());
		}catch (Exception e) {
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Exception" + e.getMessage());
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
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				logger.error("Exception" + e.getMessage());
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
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Exception" + e.getMessage());
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
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Exception" + e.getMessage());
			}
		}

		return courses;

	}

	@Override
	public int getStatus(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
        		PreparedStatement pstmtP;
                pstmtP = conn.prepareStatement(SQLQueriesConstant.GET_STATUS);

                pstmtP.setString(1, studentId);

                ResultSet resultSet = pstmtP.executeQuery();
                
                if(resultSet.next()) {
                	return resultSet.getInt("IsRegistered");
                }
                
        	
//            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
		return 0;
	}

	@Override
	public boolean updateStatus(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.UPDATE_STUDENT_STATUS);

            pstmtP.setString(1, studentId);

            pstmtP.executeUpdate();
//            conn.close();
            logger.info("Status Updated");
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
		return false;
	}

}
