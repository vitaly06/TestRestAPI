package com.simpleRestApi.demo.Models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty
    @Size(min=2, max=30, message = "Длина имени от 2 до 30 символов")
    private String name;
    @NotEmpty
    @Size(min=2, max=30, message = "Длина фамилии от 2 до 30 символов")
    private String surname;
    @Min(value = 0, message = "Возраст не может быть отрицательным")
    private int age;

    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
