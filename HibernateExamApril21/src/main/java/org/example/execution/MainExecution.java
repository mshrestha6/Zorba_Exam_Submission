package org.example.execution;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.Employee;
import org.example.entity.Skill;
import org.example.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.*;
import java.util.Iterator;

public class MainExecution {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dhund\\Zorba_Exam_Submission\\HibernateExamApril21\\src\\main\\resources\\Exam_info.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        System.out.println("binary format data: " + fileInputStream);

        //Create Hibernate Session Factory
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            int sheetCount = xssfWorkbook.getNumberOfSheets();
            System.out.println("sheet count: " + sheetCount);
            for (int i = 0; i < sheetCount; i++) {
                //get the specific sheet where we have a content
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
                System.out.println("No Of Rows Present in the sheet " + (i + 1) + " : " + xssfSheet.getPhysicalNumberOfRows());

                Iterator<Row> rowIterator = xssfSheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    System.out.println("no of Column in each row :" + row.getPhysicalNumberOfCells());

                    //iterate over the cell/column
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        System.out.println("Column - " + (cell.getColumnIndex() + 1));
                        // System.out.println("Column data type ::"+ cell.getCellType().name());
                        System.out.println("Value:");
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.println(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                System.out.println(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                System.out.println(cell.getBooleanCellValue());
                                break;

                        }
                        Sheet employeeSheet = xssfWorkbook.getSheet("Employee");

                        session.beginTransaction();
                        for (Row row1: employeeSheet) {
                            if (row.getRowNum() == 0) {
                                continue;
                            }

                            Employee employee = new Employee();
                            employee.setEmpId(Integer.valueOf(row.getCell(0).getStringCellValue()));
                            employee.setEmpName(row.getCell(1).getStringCellValue());
                            employee.setEmpAddress(row.getCell(2).getStringCellValue());
                            employee.setemployeeEmail(row.getCell(3).getStringCellValue());
                            employee.setemployeeExperience(row.getCell(4).getStringCellValue());
                            session.save(employee);

                        }
                        session.getTransaction().commit();

                        XSSFSheet skillSheet= xssfWorkbook.getSheet("Skill");
                        session.beginTransaction();
                        (for (Row row1: employeeSheet) {
                            if (row.getRowNum() == 0) {
                                continue;
                            }

                        Skill skill = new Skill();

                        skill.setName(row.getCell(1).getStringCellValue());
                        session.save(skill);
                    }
                    session.getTransaction().commit();
                }
            }

            }
        catch(Exception e){
        e.printStackTrace();
        transaction.rollback();

    }finally{
            if (session != null) {
        session.close();
                }
}
    }
}
}


