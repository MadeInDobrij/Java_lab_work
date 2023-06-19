package org.example;

import java.io.*;
import java.util.List;


public class Saver {
    public void writeToFile(Students studentList) {
        try (FileOutputStream fileOut = new FileOutputStream("output.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(studentList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createAReport(Students studentList) {
        List<StudentClass> students = studentList.getStudents();
        try (FileWriter myWriter = new FileWriter("report.txt")) {
            for (StudentClass student : students) {
                myWriter.write(student.toString());
                myWriter.write("\n");
            }
        } catch (IOException ex) {
            // Handle exception
        }
    }

    public Students readFromFile() {
        try (FileInputStream fileIn = new FileInputStream("output.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Students) objectIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
}

