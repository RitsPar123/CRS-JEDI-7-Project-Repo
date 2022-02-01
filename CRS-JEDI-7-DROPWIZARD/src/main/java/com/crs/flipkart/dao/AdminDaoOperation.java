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

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourses;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.exception.CourseFoundException;
import com.crs.flipkart.exception.CourseNotAddedException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotFoundException;
import com.crs.flipkart.exception.StudentNotFoundForApprovalException;
import com.crs.flipkart.exception.StudentNotRegisteredException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import com.crs.flipkart.exception.UserNotAddedException;
import com.crs.flipkart.utils.CRSDb;

/**
 * @author Abhinav
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
    
	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
    
    
    public boolean addCourse(Course course)  throws CourseFoundException{
    	Connection conn = CRSDb.getConnect();
        try {
            
            PreparedStatement stmt;
            stmt = conn.prepareStatement(SQLQueriesConstant.ADD_COURSE);
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());

            int row = stmt.executeUpdate();
            //conn.close();
            if(row == 0) {
				logger.error("Course with courseCode: " + course.getCourseId() + "not added to catalog.");
				throw new CourseFoundException(course.getCourseName());
			}
			
            logger.info ("Course Added");
            return true;

        } catch (Exception e) {
        	logger.error("Exception " + e.getMessage());
        }
        
        return false;
    }

    /**
    * {@inheritDoc}
    */  
    @Override
    public boolean deleteCourse(String id) throws CourseNotFoundException, CourseNotDeletedException{
        // TODO Auto-generated method stub
    	Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE);
            stmt.setString(1, id);

            int row = stmt.executeUpdate();
            
            if(row == 0) {
            	logger.error(id + " not in catalog!");
				throw new CourseNotFoundException(id);
            }
            //conn.close();
            logger.info("Course with courseCode: " + id + " deleted.");
            return true;

        } catch (Exception e) {
        	logger.error("Exception" + e.getMessage());
        	throw new CourseNotDeletedException(id);
        }
    }

    /**
    * {@inheritDoc}
    */  
    @Override
    public boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        // TODO Auto-generated method stub
    	Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.ADD_PROFESSOR);

            pstmtP.setString(1, professor.getId());
            pstmtP.setString(2, professor.getDepartment());

            int row = pstmtP.executeUpdate();

            //conn.close();
            if(row == 0) {
				logger.error("Professor with professorId: " + professor.getId() + " not added.");
				throw new ProfessorNotAddedException(professor.getId());
			}
            
            logger.info ("Professor Added ");
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        	throw new UserIdAlreadyInUseException(professor.getId());
        }
    }


    @Override
    public boolean approveStudent(String SId) throws StudentNotFoundForApprovalException{
        // TODO Auto-generated method stub
        Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENT);

            pstmtP.setString(1, SId);

            int result = pstmtP.executeUpdate();
            
            if(result == 0) {
				//logger.error("Student with studentId: " + studentId + " not found.");
				throw new StudentNotFoundForApprovalException(SId);
			}
			
            
            //conn.close();
           
            	logger.info ("Student Self Registration approved");
            	return true;
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }

        return false;
    }

    /**
    * {@inheritDoc}
    */  
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

            //conn.close();
            logger.info(studentList.size() + " Students in PendingQueue: ");
            return studentList;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
        return null;
    }

    /**
    * {@inheritDoc}
    */  
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

            //conn.close();
            logger.info(courseList.size() + " courses in catalogId: ");
            return courseList;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
        return null;
    }

    /**
    * {@inheritDoc}
    */  
	@Override
	public Set<String> viewSelectedCourse(String studentId){
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
            
//            //conn.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	logger.error("Exception " + e.getMessage());
        }
        
        return null;
	}

    /**
    * {@inheritDoc}
    */  
	@Override
	public int getCourseList(String courseId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
		try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_SEAT);
            
            pstmtP.setString(1, courseId);

            ResultSet resultSet = pstmtP.executeQuery();
            
            if(resultSet.next()) {
            	return resultSet.getInt("SeatCount");
            }
            else 
            	throw new CourseNotFoundException(courseId);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	logger.error("Exception " + e.getMessage());
        } catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Exception "+ e.getMessage());
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

	            int row = pstmtP.executeUpdate();
	            
//	            if(row == 0) {
//	            	throw new StudentNotFoundForApprovalException(studentId);
//	            }
	            conn.close();
	            
	            return true;

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	        	logger.error("Exception" + e.getMessage());
	        }

		return false;
	}

    /**
    * {@inheritDoc}
    */  
	@Override
	public Student viewStudentData(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.STUDENT_DATA);

            pstmtP.setString(1, studentId);

            ResultSet resultSet = pstmtP.executeQuery();
            
            Student stud = new Student();
            if(resultSet.next()) {
            stud.setId(resultSet.getString(1));
            stud.setBranch(resultSet.getString(2));
            stud.setUserName(resultSet.getString(3));
            stud.setRegistered(resultSet.getBoolean(4));
            stud.setReportApproved(resultSet.getBoolean(5));
            
            return stud;
            }
//            conn.close();
            else 
            	throw new StudentNotFoundException(studentId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        } catch (StudentNotFoundException e) {
			
        	logger.error("Exception "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<RegisteredCourses> activateGradeCard(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.REGISTERED_COURSE);
            
            pstmtP.setString(1, studentId);

            ResultSet resultSet = pstmtP.executeQuery();

            List<RegisteredCourses> registeredCourse = new ArrayList<RegisteredCourses>();

            while (resultSet.next()) {
            	RegisteredCourses course = new RegisteredCourses();
                course.setCourseId(resultSet.getString("CourseId"));
                course.setGrade(resultSet.getInt("Grade"));

                registeredCourse.add(course);
            }

//            conn.close();
            logger.info("Grade Card Activated");
            return registeredCourse;
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
		return null;
	}
	
	 @Override
	    public boolean approveStudentRegistration(String SId) {
	        // TODO Auto-generated method stub
	        Connection conn = CRSDb.getConnect();
	        try {
	            PreparedStatement pstmtP;
	            pstmtP = conn.prepareStatement(SQLQueriesConstant.APPROVE_REPORT);

	            pstmtP.setString(1, SId);

	            int result = pstmtP.executeUpdate();
	            if(result!=0) {
	            	conn.close();
	            	logger.info("Sem Registeration Approved");
	            	return true;
	            	}
	            else
	            	throw new StudentNotRegisteredException(SId);

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	logger.error("Exception" + e.getMessage());
	        } 
	        catch (StudentNotRegisteredException e) {
	        	
	        	logger.error("Exception "+e.getMessage());
			}
	        try {
	        	conn.close();
	        }
	        catch (SQLException e) {
				
	        	logger.error("Exception" + e.getMessage());
			}
	        return false;
	    }
	
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<>();
		
		Connection connection = CRSDb.getConnect();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(SQLQueriesConstant.GET_ALL_COURSES);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getString("CourseId"));
				course.setProfessor(resultSet.getString("PId"));
				course.setCourseName(resultSet.getString("CourseName"));
				courses.add(course);
			}
			
			return courses;
			
		} catch(Exception e) {
			logger.error("Exception" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch(Exception e) {
				logger.error("Exception" + e.getMessage());
			}
		}
		
		return courses;
	}


	@Override
	public boolean updateCourse(Set<String> courseList) {
		// TODO Auto-generated method stub
		Connection conn = CRSDb.getConnect();
        try {
        	for(String course:courseList) {
        		PreparedStatement pstmtP;
                pstmtP = conn.prepareStatement(SQLQueriesConstant.UPDATE_COURSE_ENTRY);

                pstmtP.setString(1, course);

                pstmtP.executeUpdate();
        	}
        	
            conn.close();
            logger.info("Course updated");
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        }
		return false;
	}

	@Override
	public boolean addUser(String id, String password,String name) throws UserNotAddedException, UserIdAlreadyInUseException {
		// TODO Auto-generated method stub
		
		Connection conn = CRSDb.getConnect();
        try {
            PreparedStatement pstmtP;
            pstmtP = conn.prepareStatement(SQLQueriesConstant.ADD_USER_PRO);

            pstmtP.setString(1, id);
            pstmtP.setString(2, name);
            pstmtP.setString(3, password);

            int row  = pstmtP.executeUpdate();

            //conn.close();
            logger.info("User Added");
            if(row == 0) {
				logger.error("User with userId: " + id + " not added.");
				throw new UserNotAddedException(id); 
			}

            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
        	logger.error("Exception" + e.getMessage());
        	throw new UserIdAlreadyInUseException(id);
        }

	}

}

