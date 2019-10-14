package by.epam.bean;

import java.util.Objects;

public class Staff implements java.io.Serializable{
    private String name;
    private String surname;
    private int salary;
    private JobPosition jobPosition;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) { this.jobPosition = jobPosition; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return getSalary() == staff.getSalary() &&
                Objects.equals(getName(), staff.getName()) &&
                Objects.equals(getSurname(), staff.getSurname()) &&
                getJobPosition() == staff.getJobPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getSalary(), getJobPosition());
    }

    @Override
    public String toString() {
        return "Stuff: " + "name= " + name + " surname= " + surname
                + " salary= " + String.valueOf(salary) + " job position= " + jobPosition;
    }
}
