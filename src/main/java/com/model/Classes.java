package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classid;
	private String classtitle;
	private String classname;
	
	@OneToMany(mappedBy = "classstudent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Students> students;
	
	@OneToMany(mappedBy = "classes",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Subjects> subjects;

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClasstitle() {
		return classtitle;
	}

	public void setClasstitle(String classtitle) {
		this.classtitle = classtitle;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Classes [classid=" + classid + ", classtitle=" + classtitle + ", classname=" + classname + ", students="
				+ students + ", subjects=" + subjects + "]";
	}

	public Classes(String classtitle, String classname, List<Students> students, List<Subjects> subjects) {
		super();
		this.classtitle = classtitle;
		this.classname = classname;
		this.students = students;
		this.subjects = subjects;
	}

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
