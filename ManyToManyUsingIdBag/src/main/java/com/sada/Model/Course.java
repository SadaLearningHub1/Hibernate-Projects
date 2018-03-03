package com.sada.Model;

import java.util.Set;

public class Course {
	
	private int courseId;
	private String courseName;
	private int duration;
	
	private Set students;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, int duration, Set students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.students = students;
	}
	public Course(int courseId) {
		super();
		this.courseId = courseId;
	}
	
	
}
