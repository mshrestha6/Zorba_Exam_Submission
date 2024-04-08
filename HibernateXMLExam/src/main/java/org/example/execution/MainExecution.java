package org.example.execution;

import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.entity.Teacher;
import org.example.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainExecution {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        Scanner scanner = new Scanner(System.in);


            private static void insertSubjects (Scanner scanner){
                Transaction tx = session.beginTransaction();
                for (int i = 1; i < 4; i++) {
                    System.out.println("Enter subject name: ");
                    String subjectName = scanner.nextLine();

                    Subject subject = new Subject(subjectName);
                    session.save(subject);

                }
                tx.commit();
                System.out.println("Subjects inserted");

            }

        private static void createStudent (Scanner scanner){
            System.out.println("Enter student details:::");
            System.out.println("Name: ");
            String studentname = scanner.nextLine();
            System.out.println("Enter roll number: ");
            int rollNumber = scanner.nextInt();

            Transaction tx =session.beginTransaction();
            List<Subject> subjects=session.createQuery("from Subject").list();
            System.out.println("Available subjects::");
            for(Subject subject:subjects){
                System.out.println(subject.getSubjectId()+": "+subject.getSubjectName());
            }
            System.out.println("Choose a subject:: ");
            String selectedSubject = scanner.nextLine();

            Subject selectedSubjectObj = session.get(Subject.class, selectedSubject);

            Student student = new Student(studentname, rollNumber,selectedSubject);
            session.save(student);
            tx.commit();
            System.out.println("Student inserted");

        }
        private static void createTeacher(Scanner scanner){
                System.out.println("Enter teacher's details:::");
                System.out.println("Name: ");
                String teachername = scanner.nextLine();
            System.out.println("Qualification");
            String qualification = scanner.nextLine();
            System.out.println("Experience:: ");
            String experience = scanner.nextLine();
            Transaction tx =session.beginTransaction();
            List<Subject> subjects=session.createQuery("from Subject").list();
            System.out.println("Available subjects::");
            for(Subject subject:subjects){
                System.out.println(subject.getSubjectId()+": "+subject.getSubjectName());
            }
            System.out.println("Choose a subject: ");
            String selectedSubject = scanner.nextLine();
            Subject selectedSubjectObj = session.get(Subject.class, selectedSubject);
            Teacher teacher=new Teacher(teachername,qualification,experience,selectedSubject);
            session.save(teacher);
            tx.commit();
            System.out.println("Teacher inserted");
        }
        private static void displayAllRecords(){
                Transaction tx = session.beginTransaction();

                List<Subject> subjects=session.createQuery("from Subject").list();
                List<Student> students=session.createQuery("from Student").list();
                List<Teacher> teachers=session.createQuery("from Teacher").list();
                for(Subject subject:subjects){
                    System.out.println(subject);
                }
                for(Student student:students){
                    System.out.println(student);
                }
                for(Teacher teacher: teachers){
                    System.out.println(teacher);
                }
        }


    }
}
