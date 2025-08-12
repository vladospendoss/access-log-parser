package ru.courses.people;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Student(String name, int[] startGrades) {
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : startGrades) {
            addGrade(grade);
        }
    }

    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }
        grades.add(grade);
    }


    public int[] getGrades() {
        int[] result = new int[grades.size()];
        for (int i = 0; i < grades.size(); i++) {
            result[i] = grades.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }
}