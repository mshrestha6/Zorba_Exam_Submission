package org.example;


import model.RailwayReservation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBCConnection {
    public static void main(String[] args) {

        /*try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("database.properties"));

            String url = properties.getProperty("url");
            String userName = properties.getProperty("userName");
            String password = properties.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver") ;

            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();

            System.out.println("Connection successful...");*/

            String url = "jdbc:mysql://localhost:3306/railway_ticket";
            String userName = "root";
            String password = "Tashidhundup1!";


            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection successful...");
                Statement statement=connection.createStatement();


            String sql="create table railway_reservation(passenger_name varchar(30)," +
                    "passenger age int(10),choosen seat varchar(10),reservation_type varchar(20)," +
                    "is_senior_citizen boolean, amount_paid double(20))";
                statement.executeUpdate(sql);
                System.out.println("Table created....");

                Scanner scanner=new Scanner(System.in);

                System.out.println("Enter passenger name:");
                String passengerName=scanner.nextLine();

                System.out.println("Enter passenger age: ");
                int passengerAge=scanner.nextInt();

                System.out.println("Enter choosen seat");
                String choosenSeat=scanner.nextLine();

                System.out.println("Enter type of reservation(AC or Non-AC)");
                String typeofReservation=scanner.nextLine();

                RailwayReservation reservation=new RailwayReservation(passengerName,passengerAge,choosenSeat,typeofReservation);
                reservation.calculateAmountandSeiority();

            String insertdata="insert into railway_reservation(passenger_name,passenger_age," +
                    "choosen_seat,reservation_type,is_senior_citizen,amount_paid) values(?,?,?,?,?,?)";



            } catch (Exception e) {
                System.err.println("Exception !!");
            }
        }



    }

