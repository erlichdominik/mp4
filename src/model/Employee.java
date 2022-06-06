package model;

import java.util.*;
import java.util.regex.Pattern;

public class Employee {
    private static final String EMAIL_PATTERN = "^(.+)@(\\\\S+)$";
    private final static Set<String> employeeIDs = new HashSet<>();
    // UNIQUE
    private String empoloyeeId;
    private String firstName;
    private String lastName;
    private String mail;
    //ORDERED
    private List<Computer> computers = new ArrayList<>();

    public List<Computer> getComputers() {
        return computers;
    }

    public void addComputer(Computer computer) {
        this.computers.add(computer);
        computer.setEmployee(this);
    }

    public void removeComputer(Computer computer) {
        this.computers.remove(computer);
        computer.setEmployee(null);
    }

    public Employee(String empoloyeeId, String firstName, String lastName, String mail) {
        this.empoloyeeId = empoloyeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;

        boolean add = employeeIDs.add(empoloyeeId);
        if (!add) throw new IllegalArgumentException("this employeeId already exists!");
    }



    @Override
    public String toString() {
        return "Employee{" +
                "empoloyeeId='" + empoloyeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empoloyeeId.equals(employee.empoloyeeId) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && mail.equals(employee.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empoloyeeId, firstName, lastName, mail);
    }

    public String getEmpoloyeeId() {
        return empoloyeeId;
    }

    public Set<String> getEmployeeIDs() {
        return new HashSet<>(employeeIDs);
    }

    public void setEmpoloyeeId(String empoloyeeId) {
        this.empoloyeeId = empoloyeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail == null) throw new IllegalArgumentException("mail cannot be equal to null");
        if (!patternMatches(mail)) throw new IllegalArgumentException("mail is not correct");
        this.mail = mail;
    }

    private boolean patternMatches(String emialAddress) {
        return Pattern.compile(Employee.EMAIL_PATTERN)
                .matcher(emialAddress)
                .matches();
    }
}
