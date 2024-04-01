package com.example.introspringintegration.model;

import java.time.LocalDate;

public class StudentMessage {
    private final String fullName;
    private final LocalDate birthday;
    private final int randomValue;

    // Конструкторы, геттеры и сеттеры
    public StudentMessage(String fullName, LocalDate birthday, int randomValue) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.randomValue = randomValue;
    }

    @Override
    public String toString() {
        return "StudentMessage{" +
                "fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", randomValue=" + randomValue +
                '}';
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
