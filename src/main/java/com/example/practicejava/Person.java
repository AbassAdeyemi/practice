package com.example.practicejava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
       return String.format("%s -- %s", name, age);
    }
}
