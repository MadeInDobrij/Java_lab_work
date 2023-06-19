package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentClass implements Serializable {
    public String name;
    public String ID;
    public String email;
    public LocalDate dateOfBirth;


    public StudentClass() {
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nID: " + ID +
                "\nMail: " + email +
                "\nDate of Birth: " + dateOfBirth;
    }
}

