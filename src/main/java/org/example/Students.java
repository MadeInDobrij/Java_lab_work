package org.example;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Students implements Serializable {
    private final List<StudentClass> students=new ArrayList<>();
    public void add(){
        StudentClass student=new StudentClass();
        System.out.println("Type name");
        student.name=Main.scanner.nextLine();
        System.out.println("Type id");
        student.ID=Main.scanner.nextLine();
        System.out.println("Type email");
        student.email=Main.scanner.nextLine();
        System.out.println("Type your date of birth");
        try {
            System.out.println("Type year");
            int year = Main.scanner.nextInt();
            System.out.println("Type month");
            int month = Main.scanner.nextInt();
            System.out.println("Type day");
            int day=Main.scanner.nextInt();
            student.dateOfBirth=LocalDate.of(year,month,day);
            students.add(student);
            Main.logger.info("New student registered");
        }
        catch (DateTimeException e) {
            Main.logger.info("Incorrect input");
        }
    }



    public void remove(){
        System.out.println("Enter ID of student");
        String id=Main.scanner.nextLine();
        try {
            StudentClass searchedStudent=search(id);
            students.remove(searchedStudent);
            Main.logger.info("Student deleted");
        }
        catch (Exception e){
            Main.logger.info("Incorrect input");
        }

    }
    public StudentClass search(String id){
        StudentClass searchedStudent;
        try{
            searchedStudent=students.stream().filter(student -> student.ID.equals(id)).findAny().get();
            return searchedStudent;
        }
        catch (Exception e){
            return null;
        }
    }
    public void searchAndShowStudent(){
        System.out.println("Enter ID of student");
        String id=Main.scanner.nextLine();
        try {
            StudentClass foundStudent=search(id);
            System.out.println(foundStudent);
        }
        catch (Exception e){
            Main.logger.info("Incorrect input");
        }
    }
    public List<StudentClass> getStudents() {
        return students;
    }
}

