package com.hitema.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO : Plain Old Java Object - Bon vieil objet Java
 */
@Entity
@DiscriminatorValue("S")
public class Student extends Person{
    private String cursus;

    public Student() {
    }

    public Student(Integer id, String lastName, String firstName, LocalDate birthDate, String genre, String email, String cursus) {
        super(id, lastName, firstName, birthDate, genre, email);
        this.cursus = cursus;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "cursus='" + cursus + '\'' +
                "} " ;
    }
}
