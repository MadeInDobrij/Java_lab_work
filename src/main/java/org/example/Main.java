package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import java.util.Scanner;

public class Main {
    public static Logger logger = Logger.getGlobal();
    public static Scanner scanner = new Scanner(System.in);
    public static Saver loader = new Saver();
    private static boolean isEnd = false;

    public static void main(String[] args) {
        Students studentList;
        studentList = loader.readFromFile();
        if (studentList == null) {
            studentList = new Students();
        }
        while (!isEnd) {
            displayMainMenu();
            executeMainMenuFunction(studentList);
        }
        loader.writeToFile(studentList);
    }

    public static void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("1. add new");
        System.out.println("2. delete student");
        System.out.println("3. create report about all students");
        System.out.println("4. search");
        System.out.println("5. Quit");
    }

    public static void executeMainMenuFunction(Students studentList) {
        String input;
        List<String> possibleInputs = Arrays.asList("1", "2", "3", "4", "5");
        scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            if (possibleInputs.contains(input)) {
                break;
            } else {
                System.out.println("Type number 1-5");
            }
        }
        switch (input) {
            case "1":
                studentList.add();
                break;
            case "2":
                studentList.remove();
                break;
            case "3":
                loader.createAReport(studentList);
                break;
            case "4":
                studentList.searchAndShowStudent();
                break;
            case "5":
                isEnd = true;
                break;
        }
    }
}