package model;

import java.io.Serializable;

/**
 * @author dominikerlich
 * @created 24/03/2022
 * @project MP1
 */
public class Person implements Serializable {
    private String name;
    private String surname;

    public Person(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("name of the Person cannot be an empty String");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.isEmpty() || surname.isBlank()) throw new IllegalArgumentException("surname of the Person cannot be an empty String");
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
