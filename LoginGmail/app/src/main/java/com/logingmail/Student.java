package com.logingmail;

public class Student {
    public String name;
    public String classes;

    Student(String name, String classes) {
        name = this.name;
        classes = this.classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
