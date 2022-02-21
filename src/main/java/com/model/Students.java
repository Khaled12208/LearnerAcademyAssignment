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
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	private String studentname;
	private String studentaddress;
	private String studentcontact;
	private String studentemail;

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "classid",insertable = false,updatable = false)
	private Classes classstudent;
	private Integer classid;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public String getStudentcontact() {
		return studentcontact;
	}
	public void setStudentcontact(String studentcontact) {
		this.studentcontact = studentcontact;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public Classes getClassstudent() {
		return classstudent;
	}
	public void setClassstudent(Classes classstudent) {
		this.classstudent = classstudent;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Students(String studentname, String studentaddress,
			String studentcontact, String studentemail, Classes classstudent, Integer classid) {
		super();
		this.studentname = studentname;
		this.studentaddress = studentaddress;
		this.studentcontact = studentcontact;
		this.studentemail = studentemail;
		this.classstudent = classstudent;
		this.classid = classid;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
