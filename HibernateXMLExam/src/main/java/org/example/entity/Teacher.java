package org.example.entity;

import java.util.Set;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String qualification;
    private int teacherExperience;
    private Set<Student> students;//One to Many relationship with student

    public Teacher(String teachername, String qualification, String experience, String selectedSubject) {
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getTeacherExperience() {
        return teacherExperience;
    }

    public void setTeacherExperience(int teacherExperience) {
        this.teacherExperience = teacherExperience;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", teacherExperience=" + teacherExperience +
                ", students=" + students +
                '}';
    }
}
