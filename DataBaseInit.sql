
CREATE DATABASE learnacademy4;
USE LearnAcademy4;

CREATE TABLE Users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) ,
password VARCHAR(30) ,
email  VARCHAR(30) 
);

INSERT INTO Users ( username, password, email)
VALUES ("admin", "admin", "admin@gmail.com"); 

CREATE TABLE Teachers (
teacherid INT  AUTO_INCREMENT PRIMARY KEY,
teachername VARCHAR(30) ,
teacheremail VARCHAR(30) ,
teachercontact  VARCHAR(30) 
);

INSERT INTO Teachers ( teachername, teacheremail, teachercontact)
VALUES ("Khaled", "Khaled@gmail.com", "0122126146620"); 


CREATE TABLE Classes (
classid INT AUTO_INCREMENT PRIMARY KEY,
classtitle VARCHAR(30),
classname VARCHAR(30)
);

INSERT INTO Classes ( classtitle, classname)
VALUES ("Tigers", "A-11"); 

CREATE TABLE Subjects (
subjectid INT AUTO_INCREMENT PRIMARY KEY,
subjectname VARCHAR(30),
teacherid INT,
classid INT,
FOREIGN KEY(classid) REFERENCES Classes (classid),
FOREIGN KEY(teacherid) REFERENCES Teachers (teacherid)
);

INSERT INTO Subjects (subjectname)
VALUES ("Physics"); 

CREATE TABLE Students (
studentid INT AUTO_INCREMENT PRIMARY KEY,
studentname VARCHAR(30),
studentaddress VARCHAR(30),
studentcontact  VARCHAR(30),
studentemail  VARCHAR(30),
classid INT ,
FOREIGN KEY(classid) REFERENCES Classes(classid)
);

INSERT INTO Students (studentname, studentaddress, studentcontact ,studentemail)
VALUES ("Khaled", "aa st", "012222","khaled@gmail.com"); 