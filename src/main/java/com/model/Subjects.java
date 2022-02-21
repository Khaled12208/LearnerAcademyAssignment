package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectid;
	private String subjectname;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "classid",insertable = false,updatable = false)
	private Classes classes;
	private int classid;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherid",insertable = false ,updatable = false)
	private Teachers teachers;
	private Integer teacherid;
	
	
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	
	@Override
	public String toString() {
		return "Subjects [subjectid=" + subjectid + ", subjectname=" + subjectname + ", classes=" + classes
				+ ", classid=" + classid + ", teachers=" + teachers + ", teacherid=" + teacherid + "]";
	}
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subjects(String subjectname, Classes classes, int classid, Teachers teachers, Integer teacherid) {
		super();
		this.subjectname = subjectname;
		this.classes = classes;
		this.classid = classid;
		this.teachers = teachers;
		this.teacherid = teacherid;
	}
	
}
