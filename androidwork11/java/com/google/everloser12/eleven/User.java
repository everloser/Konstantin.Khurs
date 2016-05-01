package com.google.everloser12.eleven;

/**
 * Created by al-ev on 29.04.2016.
 */
public class User {

    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if (age == 0)
        return "id = " + id +", name = \"" + name + "\"";
        else
            return "id = " + id +", name = \"" + name + "\", age = " + age;
    }
}
