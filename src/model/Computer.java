package model;

import java.util.Objects;

public class Computer {
    private String computerId;
    private String serialNumber;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return computerId.equals(computer.computerId) && serialNumber.equals(computer.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(computerId, serialNumber);
    }

    public Computer(String computerId, String serialNumber) {
        this.computerId = computerId;
        this.serialNumber = serialNumber;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
