package org.example.entity;

public class Student {
    private int studentId;
    private String studentName;
    private String rollNumber;
    private Subject subject;

    public Student(String name, int rollNumber, String selectedSubject) {
    }

    //Many-to-one relationship with Subject

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", subject=" + subject +
                '}';
    }
}
