package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static org.example.Connection.getConnection;


public class MainClassExecution {
    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:mysql://localhost:3306/jdbcexam";
        String userName = "root";
        String password = "Tashidhundup1!";
        // PreparedStatement preparedStatement=null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection successful...");
            Statement statement=connection.createStatement();


            /*String data = "create table student(stud_id int(10) not null auto_increment primary key," +
                    "stud_name varchar(55),stud_age int(10),stud_dob datetime," +
                    "stud_marks decimal(12,3))";

            PreparedStatement preparedStatement = connection.prepareStatement(data);
            preparedStatement.executeUpdate(data);

            System.out.println("Table student created..");*/
            /*String data="create table department(dept_id int(10) not null auto_increment primary key," +
                    "dept_name varchar(20),dept_location varchar(30),stud_id int(10)," +
                    "foreign key (stud_id) references student(stud_id))";
            statement.executeUpdate(data);
            System.out.println("Department table created...");*/

           /* String data="create table stud_sub_score(sub_id int(10) not null auto_increment primary key," +
                    "sub_name varchar(20),sub_score decimal(12,3),stud_id int(10)," +
                    "foreign key (stud_id) references student(stud_id))";
            statement.executeUpdate(data);
            System.out.println("Last table created...");*/

            String studentinsert="insert into student(stud_name,stud_age,stud_dob) values (?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(studentinsert);



            Scanner scanner =new Scanner(System.in);

            System.out.println("Enter student details...");
            System.out.println("Enter student name: ");
            String studName=scanner.nextLine();

            System.out.println("Enter student age: ");
            int studAge=scanner.nextInt();

            System.out.println("Date of birth (YYYY-MM-DD): ");
            String dob=scanner.next();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date conDate = simpleDateFormat.parse(dob);
            SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
            String convertedDate = dbFormat.format(conDate);


            preparedStatement.setString(1,studName);
            preparedStatement.setInt(2,studAge);
            preparedStatement.setString(3,dob);
            preparedStatement.executeUpdate();

            //Insert in department

            String departmentinsert="insert into department values(?,?,?)";
            PreparedStatement preparedStatement1= connection.prepareStatement(departmentinsert);

            System.out.println("Enter department details...");
            System.out.println("Department Name: ");
            String deptName=scanner.nextLine();

            System.out.println("Enter Department Location: ");
            String deptLocation=scanner.nextLine();

            System.out.println("Enter student id: ");
            int studId=scanner.nextInt();

            preparedStatement1.setString(1,deptName);
            preparedStatement1.setString(2,deptLocation);
            preparedStatement1.setInt(3,studId);
            preparedStatement1.executeUpdate();

            System.out.println("Data inserted successfully");

            //Insert subject scores

            String subinsert="insert into stud_sub_score values(?,?,?)";
            PreparedStatement preparedStatement2=connection.prepareStatement(subinsert);

            System.out.println("Enter subject scores for the student::");
            for(int i=0;i<4;i++){
                System.out.println("Enter subject name: ");
                String subName=scanner.nextLine();

                System.out.println("Enter Subject Score: ");
                double subscore=scanner.nextDouble();

                System.out.println("Enter student ID: ");
                int studentId=scanner.nextInt();

                preparedStatement2.setString(1,subName);
                preparedStatement2.setDouble(2,subscore);
                preparedStatement2.setInt(3,studentId);

                String alter="Alter table student add column stud_marks decimal(12,3)";
                statement.executeUpdate(alter);

                //stud_marks update through stored procedure

                CallableStatement callableStatement=connection.prepareCall("{call UpdateStudentMarks(?)}");
                callableStatement.setInt(1,studId);
                callableStatement.executeUpdate();



            }



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
