/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author harsh
 *
 */
public class Course {
	private int count;
	private String courseName;
	private String courseId;
	private String professor;
	private boolean isOffered;
	private double marks;

	/** Parameterized constructor 
	 * @param count
	 * @param courseName
	 * @param courseId
	 * @param professor
	 */
	public Course(int count, String courseName, String courseId, String professor) {
		this.count = count;
		this.courseName = courseName;
		this.courseId = courseId;
		this.professor = professor;
	}


	/**Method to get count of registered students
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**Method to set count of registered students
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**Method to get CourseName of a course object
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**Method to set CourseName of a course object
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**Method to get courseId
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**Method to set courseId
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**Method to get professorId
	 * @return the professor
	 */
	public String getProfessor() {
		return professor;
	}

	/**Method to set ProfessorId
	 * @param professor the professor to set
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	/**Method to get isOffered status
	 * @return the isOffered
	 */
	public boolean isOffered() {
		return isOffered;
	}

	/**Method to set isOffered status
	 * @param isOffered the isOffered to set
	 */
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

	/**Method to get marks 
	 * @return the marks
	 */
	public double getMarks() {
		return marks;
	}

	/**Method to set marks
	 * @param marks the marks to set
	 */
	public void setMarks(double marks) {
		this.marks = marks;
	}

	
	
}
