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

<<<<<<< HEAD
	public Course() {
		
	}
	
	public Course(int count, String courseName, String courseId) {
		this.count = count;
		this.courseName = courseName;
		this.courseId = courseId;
	}
=======
	public Course() {}
>>>>>>> 5906df70e161e2e26ef745be379a7f3743b912ff
	
	public Course(int count, String courseName, String courseId, String professor) {
		this.count = count;
		this.courseName = courseName;
		this.courseId = courseId;
		this.professor = professor;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the professor
	 */
	public String getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	/**
	 * @return the isOffered
	 */
	public boolean isOffered() {
		return isOffered;
	}

	/**
	 * @param isOffered the isOffered to set
	 */
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

	/**
	 * @return the marks
	 */
	public double getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(double marks) {
		this.marks = marks;
	}

	
}
